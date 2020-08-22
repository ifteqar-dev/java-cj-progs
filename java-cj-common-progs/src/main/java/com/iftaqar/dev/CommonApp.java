package com.iftaqar.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iftaqar.dev.utils.CommonUtils;

/**
 * Hello world!
 *
 */
public class CommonApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonApp.class);

	public static void main(String[] args) {
		
		CommonUtils.setCorrelation();
		
		LOGGER.debug("main method started");
		
		System.out.println("Hello World");
		
		LOGGER.debug("main method completed");
	}
}
