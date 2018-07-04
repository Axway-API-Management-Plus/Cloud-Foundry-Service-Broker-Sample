package com.axway.apim.servicebroker.service;

import static org.assertj.core.api.Assertions.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.axway.apim.servicebroker.exception.AxwayException;
import com.axway.apim.servicebroker.service.AxwayUserClient;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureWireMock(port = 8081)
@TestPropertySource(properties = { "axway_apimanager_url=http://localhost:8081" })

public class AxwayUserClientTest {

	@Autowired
	private AxwayUserClient axwayUserClient;

	@Test
	public void testCreateUser() {

		String email = "anna@demo.axway.com";
		String orgId = "9aef95ec-8167-46ab-8270-19cf1582c03f";

		

		try {
			axwayUserClient.createUser(orgId, email);
		} catch (AxwayException e) {
			e.printStackTrace();
			fail("Test failed");
		}
		

	}
	
	
	@Test
	public void testResetPassword() {
		String userId = "13c54603-1fe3-40f5-b985-b54ca34243d1";
		axwayUserClient.resetPassword(userId);
	}

}
