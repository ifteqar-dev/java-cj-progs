package com.iftaqar.dev.utils;

import java.util.UUID;

import org.slf4j.MDC;

import com.iftaqar.dev.constants.CommonConstants;

public class CommonUtils {
	
	public static void setCorrelation() {
		MDC.put(CommonConstants.CORRELATION_ID, generateCorrelationID());
	}

	public static String generateCorrelationID() {
		return String.format("cj-common-progs~%s", UUID.randomUUID().toString());
	}
}
