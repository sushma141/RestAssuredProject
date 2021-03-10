package com.api.testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.rootLib.RootClass;

import io.restassured.response.Response;
@Listeners(com.api.rootLib.TakeListner.class)
public class FetchAllCountryTest extends RootClass {
	@Test
	public void fetchAllCountryTest() {
		String apiData=config.getPropertyObject("getAllContriesData");
		Response resp=config.executeRequest(apiData);
		resp.then().log().all();
		
	}
}


