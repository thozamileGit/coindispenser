package com.fnb.coindispenser.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CoinDispenserService {
	
	public ArrayList<Integer> getMinimumCoins(int amount, String denomination) {
		int[] denominationArray = null;

		if (!StringUtils.isBlank(denomination)) {
			// creating int array from string array.
			denominationArray = Arrays.stream(denomination.split(",")).mapToInt(Integer::parseInt).toArray();
		}
		// Initialize Response
		ArrayList<Integer> response = new ArrayList<Integer>();
		int size = denominationArray.length;
		
		for (int i = size - 1; i >= 0; i--) {
			// Find denominations
			while (amount >= denominationArray[i]) {
				amount -= denominationArray[i];
				response.add(denominationArray[i]);
			}
		}

		return response;

	}

}
