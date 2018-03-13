package com.airtel.problem.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airtel.problem.entity.EventDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataLoader {

	public static List<EventDetails> list = new ArrayList<>();
	static {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(DataLoader.class.getResourceAsStream("/EventData.txt"));

		String line = "";
		StringBuffer sb = new StringBuffer();

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			sb.append(line);

		}

		String[] jsonArray = sb.toString().split("\\{");
		for (int i = 1; i < jsonArray.length; i++) {
			String js = "{" + jsonArray[i];

			ObjectMapper mapper = new ObjectMapper();
			try {
				EventDetails eventDetailsList = mapper.readValue(js, EventDetails.class);
				list.add(eventDetailsList);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

}
