package com.airtel.problem.service;

import java.util.Set;

public interface AirtelService {

	Set<String> getEventsName();

	Set<String> getUniqueUsersUnderCategoryAndDate(String category, Long date);

	Set<String> getUniqueUsersOnAParticularDateDroppedOfFromPayment(Long day);

	String getConversionPercentageOnADate(Long date);

	Set<String> getUniqueUserWhoVisitedThriceInAWeek();

}
