package com.axway.apim.servicebroker.service;


import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.axway.apim.servicebroker.model.APIOrganizationAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8081)
@TestPropertySource(properties = { "axway_apimanager_url=http://localhost:8081/" })
public class AxwayAPIClientTest {

	@Autowired
	private AxwayOrganzationClient axwayOrganzationClient;

	@Autowired
	AxwayAPIClient axwayAPIClient;

	@Test
	public void testListAPIs() {
		String orgName = "Axway";

		String orgId = axwayOrganzationClient.getOrganizationId(orgName);
		List<APIOrganizationAccess> axwayFrondendAPIs = axwayAPIClient.listAPIs(orgId);
		if (axwayFrondendAPIs.isEmpty()) {
			fail("API not found");
		}
	}

	@Test
	public void testDeleteAPI() {

	}

}
