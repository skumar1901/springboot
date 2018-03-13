package com.airtel.problem.integration;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.problem.service.AirtelService;
import com.airtel.problem.service.AirtelServiceImpl;

@RestController
@RequestMapping("/app")
public class AppServiceEndpoint {
	
	AirtelService airtelService = new AirtelServiceImpl();

	final static Logger logger = Logger.getLogger(AppServiceEndpoint.class);
	
	@RequestMapping(value = "/users/eventName", method = RequestMethod.GET)
	public Set<String> getEventsName() {
		logger.info("getEventsName::");
		return airtelService.getEventsName();

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Set<String> getUniqueUsersUnderCategoryAndDate(@RequestParam("category") String category,
			@RequestParam("date") Long date) {
		logger.info("getUniqueUsers matching category and date:");
		return airtelService.getUniqueUsersUnderCategoryAndDate(category, date);
	}

	@RequestMapping(value = "/users/dropoff", method = RequestMethod.GET)
	public Set<String> getUniqueUsersOnAParticularDateDroppedOfFromPayment(@RequestParam("day") Long day) {
		logger.info("getUniqueUsers on Particular Date droppedoff from the Payment:");
		return airtelService.getUniqueUsersOnAParticularDateDroppedOfFromPayment(day);
	}

	@RequestMapping(value = "/users/conversionPercentage", method = RequestMethod.GET)
	public String getConversionPercentageOnADate(@RequestParam("date") Long date) {
		logger.info("get Conversion rate on the service on a Date:");
		return airtelService.getConversionPercentageOnADate(date);
	}

	@RequestMapping(value = "/users/unique", method = RequestMethod.GET)
	public Set<String> getUniqueUserWhoVisitedThriceInAWeek() {
		logger.info("get All the users who visited thrice or more in 7 days");
		return airtelService.getUniqueUserWhoVisitedThriceInAWeek();
	}

}
