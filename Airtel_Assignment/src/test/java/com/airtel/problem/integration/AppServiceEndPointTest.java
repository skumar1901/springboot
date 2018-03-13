package com.airtel.problem.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppServiceEndPointTest {

	AppServiceEndpoint appService=new AppServiceEndpoint();
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetEventsName() {
		Set<String> expectedReturn=new HashSet<>();
		expectedReturn.add("FlightBooking");
		expectedReturn.add("Payment");
		expectedReturn.add("Visit");
		expectedReturn.add("RailwayTickeSearch");
		expectedReturn.add("FlightSearch");
		expectedReturn.add("HotelSearch");
		Set<String> actualReturn=appService.getEventsName();
		Assert.assertArrayEquals(expectedReturn.toArray(), actualReturn.toArray());
	}
	
	@Test
	public void testgetUniqueUsersUnderCategoryAndDate() {
		Set<String> expectedReturn=new HashSet<>();
		expectedReturn.add("u0024");
		expectedReturn.add("u0023");
		expectedReturn.add("u0010");
		expectedReturn.add("u0021");
		expectedReturn.add("u0020");
		expectedReturn.add("u005");
		expectedReturn.add("u001");
		expectedReturn.add("u0014");
		Set<String> actualReturn=appService.getUniqueUsersUnderCategoryAndDate("Search", 1514831400000l);
		Assert.assertArrayEquals(expectedReturn.toArray(), actualReturn.toArray());
	}
	
	@Test
	public void testgetConversionPercentageOnADate() {
		String expected="12.5";
		String actual=appService.getConversionPercentageOnADate(1511461800000l);
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testgetConversionPercentageOnADate_with_wrongExpected() {
		String unexpected="12";
		String actual=appService.getConversionPercentageOnADate(1511461800000l);
		Assert.assertNotEquals(unexpected, actual);
		
	}
	
	@Test
	public void testGetUniqueUserWhoVisitedThriceInAWeek() {
		String[] stringArray = new String[] { "u002", "u001", "u004", "u003", "u000", "u0013", "u0024", "u0012",
				"u009", "u0023", "u0011", "u0022", "u0010", "u0021", "u0020", "u005", "u008", "u007", "u0019",
				"u0017", "u0016", "u0015", "u0014" };
		Set<String> actualReturn = appService.getUniqueUserWhoVisitedThriceInAWeek();
		Assert.assertArrayEquals(stringArray, actualReturn.toArray());
	}
	
	@Test
	public void testGetUniqueUsersOnAParticularDateDroppedOfFromPayment() {
		String[] stringArray=new String[] {"u0024","u0023","u0021","u0010","u0020","u005","u001","u0014"};
		Set<String> actualReturn = appService.getUniqueUsersOnAParticularDateDroppedOfFromPayment(1514831400000l);
		Assert.assertArrayEquals(stringArray, actualReturn.toArray());
	}

	
	
}
