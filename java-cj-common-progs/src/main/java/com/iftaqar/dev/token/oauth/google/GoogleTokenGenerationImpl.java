package com.iftaqar.dev.token.oauth.google;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.iftaqar.dev.utils.CommonUtils;

public class GoogleTokenGenerationImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleTokenGenerationImpl.class);

	public static void main(String[] args) {

		CommonUtils.setCorrelation();

		// Get Token
		TokenResponse tokenResponse = TokenUtils.generateToken();

		//if we want to verify, whether token is expired or not, set the token with minus value
		//tokenResponse.setExpiresInSeconds(-1L);
		
		// convert tokenTime to MilliSeconds
		Long expiresInMilliSeconds = Instant.now().toEpochMilli() + tokenResponse.getExpiresInSeconds() * 1000;
		
		
		boolean isTokenExpired = TokenUtils.checkToken(expiresInMilliSeconds);
		LOGGER.info("Is Token Expired: {} ", isTokenExpired);
		
	}

}
