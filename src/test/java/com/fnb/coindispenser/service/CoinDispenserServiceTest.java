package com.fnb.coindispenser.service;


import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureWebTestClient
@ActiveProfiles({ "local", "test" })
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CoinDispenserServiceTest {
	@Autowired
	CoinDispenserService coinDispenserService;

	@Test
	void testFindMimalCoinfor_1() {
		ArrayList<Integer> result = coinDispenserService.getMinimumCoins(1, "1,2,4,5");
		Assertions.assertEquals(1, result.get(0));
		Assertions.assertEquals(1, result.size());
	}

	@Test
	void testFindMimalCoinfor_10() {
		ArrayList<Integer> result = coinDispenserService.getMinimumCoins(10, "1,2,4,5");
		Assertions.assertEquals(5, result.get(0));
		Assertions.assertEquals(5, result.get(1));
		Assertions.assertEquals(2, result.size());
	}

	@Test
	void testFindMimalCoinfor_nagative() {
		ArrayList<Integer> result = coinDispenserService.getMinimumCoins(-1, "1,2,4,5");
		Assertions.assertEquals(0, result.size());
	}

	@Test
	void testFindMimalCoinfor_zero() {
		ArrayList<Integer> result = coinDispenserService.getMinimumCoins(0, "1,2,4,5");
		Assertions.assertEquals(0, result.size());
	}

}
