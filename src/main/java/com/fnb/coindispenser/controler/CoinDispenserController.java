package com.fnb.coindispenser.controler;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fnb.coindispenser.service.CoinDispenserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1.0")
@Slf4j
public class CoinDispenserController {
	
	@Autowired
	private CoinDispenserService coinDispenserService;
	
	@Value("${denomination}")
	private String denomination;
	
	@Value("${message}")
	private  String message;
	
	@Value("${negativeNumberValidation}")
	private  String negativeNumberValidation;
	
	@Value("${denominations}")
	private  String denominations;
	

	@GetMapping("/findMinimumCoins/{amount}")
	public ResponseEntity<String> getMinimumCoins(@PathVariable("amount") @NotNull int amount) {
	try {
			if (amount <= 0) {
				return new ResponseEntity<>(negativeNumberValidation, HttpStatus.BAD_REQUEST);
			}
			
			if (StringUtils.isBlank(denomination)) {
				return new ResponseEntity<>(denominations, HttpStatus.BAD_REQUEST);
			}

			ArrayList<Integer> response = coinDispenserService.getMinimumCoins(amount, denomination);

			if (response.isEmpty()) {
				return new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
			}
			
			String responseMessage = message + ":" + amount + "  is " + response.toString();
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} catch (Exception e) {
			log.error("[getSAPSystemCustomerNumberAndLocation] " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/findMinimumCoinsUsingDenomination/{amount}/{denominations}")
	public ResponseEntity<String> getMinimalCoins(@PathVariable("amount") @NotNull int amountParam,
			@PathVariable("denominations") @NotNull String denominationParam) {
		try {

			if (amountParam <= 0) {
				return new ResponseEntity<>(negativeNumberValidation, HttpStatus.BAD_REQUEST);
			}

			if (StringUtils.isBlank(denominationParam)) {
				return new ResponseEntity<>(denominations, HttpStatus.BAD_REQUEST);
			}
			ArrayList<Integer> response = coinDispenserService.getMinimumCoins(amountParam, denominationParam);
			if (response.isEmpty()) {
				return new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
			}
			String responseMessage = message + ":" + amountParam + "  is " + response.toString();
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} catch (Exception e) {
			log.error("[getSAPSystemCustomerNumberAndLocation] " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
