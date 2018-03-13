package com.airtel.problem.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.airtel.problem.dao.DataLoader;
import com.airtel.problem.entity.EventDetails;
import com.airtel.problem.integration.AppServiceEndpoint;

public class AirtelServiceImpl implements AirtelService {

	final static Logger logger = Logger.getLogger(AppServiceEndpoint.class);

	@Override
	public Set<String> getEventsName() {
		Set<String> eventsName = DataLoader.list.stream().map(eventDetails -> eventDetails.getEventName())
				.collect(Collectors.toSet());
		return eventsName;
	}

	@Override
	public Set<String> getUniqueUsersUnderCategoryAndDate(String category, Long date) {

		Set<String> users = DataLoader.list.stream()
				.filter(eventDetails -> eventDetails.getEventType().equalsIgnoreCase(category)
						&& getTimeStampfroMillisOfDate(date).equals(parseDate(eventDetails.getTs())))
				.map(eventDetails -> eventDetails.getUserId()).collect(Collectors.toSet());
		return users;
	}

	@Override
	public Set<String> getUniqueUsersOnAParticularDateDroppedOfFromPayment(Long date) {

		Set<String> uniqueUsers = new HashSet<>();

		Map<String, List<EventDetails>> map = DataLoader.list.stream()
				.filter(eventDetails -> getTimeStampfroMillisOfDate(date).equals(parseDate(eventDetails.getTs())))
				.collect(Collectors.groupingBy(EventDetails::getUserId));
		logger.info("map with userId as Key and Object as value to be iterated");
		for (Map.Entry<String, List<EventDetails>> entry : map.entrySet()) {
			Set<String> eventTypeSet = new HashSet<>();
			int size = entry.getValue().size();
			for (int i = 0; i < size; i++) {
				String eventType = entry.getValue().get(i).getEventType();
				eventTypeSet.add(eventType);
			}
			if (!eventTypeSet.contains("Payment")) {
				uniqueUsers.add(entry.getKey());
			}
		}
		return uniqueUsers;

	}

	@Override
	public String getConversionPercentageOnADate(Long date) {

		Set<String> uniqueUsers = DataLoader.list.stream()
				.filter(eventDetails -> getTimeStampfroMillisOfDate(date).equals(parseDate(eventDetails.getTs())))
				.map(eventDetails -> eventDetails.getUserId()).collect(Collectors.toSet());

		double uniqueUsersCount = uniqueUsers.size();

		Set<String> userWhoBooked = DataLoader.list.stream()
				.filter(eventDetails -> getTimeStampfroMillisOfDate(date).equals(parseDate(eventDetails.getTs()))
						&& eventDetails.getEventType().equalsIgnoreCase("Payment"))
				.map(eventDetails -> eventDetails.getUserId()).collect(Collectors.toSet());
		double userWhoBookedCount = userWhoBooked.size();
		double conversionPercentage = (userWhoBookedCount / uniqueUsersCount) * 100;
		return String.valueOf(conversionPercentage);
	}

	@Override
	public Set<String> getUniqueUserWhoVisitedThriceInAWeek() {
		Set<String> uniqueUsers = new HashSet<>();
		Map<String, List<EventDetails>> map = DataLoader.list.stream()
				.filter(eventDetails -> eventDetails.getEventType().equalsIgnoreCase("Visit"))
				.collect(Collectors.groupingBy(EventDetails::getUserId));

		logger.info("All the users who opened the page first would be logged under EventType:Visit");
		for (Map.Entry<String, List<EventDetails>> entry : map.entrySet()) {
			Collections.sort(entry.getValue(), new Comparator<EventDetails>() {

				@Override
				public int compare(EventDetails o1, EventDetails o2) {
					Date date1 = null;
					Date date2 = null;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
					try {
						date1 = sdf.parse(o1.getTs());
						date2 = sdf.parse(o2.getTs());
					} catch (ParseException e) {
						logger.error(e.getCause());
						logger.error(e.getMessage());
					}

					return date1.compareTo(date2);
				}
			});
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			// iteration till third last value only;as all the combination of 3 events can
			// be captured
			for (int i = 0; i < entry.getValue().size() - 2; i++) {
				try {
					Date initial = sdf.parse(entry.getValue().get(i).getTs());
					Date middle = sdf.parse(entry.getValue().get(i + 1).getTs());
					Date last = sdf.parse(entry.getValue().get(i + 2).getTs());

					Date weekLast = getDateAfter7Days(initial);

					if (middle.before(weekLast) && last.before(weekLast)) {
						uniqueUsers.add(entry.getKey());
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return uniqueUsers;
	}

	// to get the date of 7 days after a given date
	private Date getDateAfter7Days(Date initial) {
		Calendar c = Calendar.getInstance();
		c.setTime(initial);
		c.add(Calendar.DATE, 7);
		return c.getTime();
	}

	private String parseDate(String date) {
		String[] dates = date.substring(0, date.indexOf("T")).split("-");
		int mYear = Integer.parseInt(dates[0]);
		int mMonth = Integer.parseInt(dates[1]);
		int mDay = Integer.parseInt(dates[2]);

		return String.valueOf(mYear) + "-" + String.valueOf(mMonth) + "-" + String.valueOf(mDay);

	}

	private String getTimeStampfroMillisOfDate(Long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH) + 1;
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);

		return String.valueOf(mYear) + "-" + String.valueOf(mMonth) + "-" + String.valueOf(mDay);
	}

}
