package com.iftaqar.dev.token.oauth.google;

import java.io.IOException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.iftaqar.dev.constants.CommonConstants;

public class TokenUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);

	public static TokenResponse generateToken() {
		LOGGER.debug("generateToken method started");
		TokenResponse response = null;
		try {

			String iamTokenUrl = "https://iam.cloud.ibm.com/identity/token";
			String iamGrantType = "urn:ibm:params:oauth:grant-type:apikey";
			String iamApiKey = CommonConstants.API_KEY;

			response = new AuthorizationCodeTokenRequest(new NetHttpTransport(), new JacksonFactory(),
					new GenericUrl(iamTokenUrl), "").setGrantType(iamGrantType).set("apikey", iamApiKey).execute();

			LOGGER.debug("Token has been generated");
			LOGGER.debug("AccessToken: {}", response.getAccessToken());
			LOGGER.debug("Token Type: {}", response.getTokenType());
			LOGGER.debug("Token Expires In: {}", response.getExpiresInSeconds());

		} catch (IOException e) {
			LOGGER.error("Exception occured in TokenGeneration class: ", e);
		}

		LOGGER.debug("generateToken method completed");
		return response;

	}

	/**
	 * 
	 * @param expiresIn
	 * @return false is not expired / true is expired checkToken takes token
	 *         milliSeconds as input and checks with the current SystemMilliseconds
	 */
	public static boolean checkToken(long expiresIn) {
		return expiresIn < (Instant.now().toEpochMilli());
	}
}
