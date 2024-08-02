package com.test.kerja.sqa.api.indodax;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	public static String getFirstName() {
		String generateStringValue = RandomStringUtils.randomAlphabetic(1);
		return "Budi_"+generateStringValue;
	}

}
