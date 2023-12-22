package afc.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class DataJsonManager {

	public static DataJsonManager getDataJSON() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.TEST_DATA_PATH + "NopCommerce.json"), DataJsonManager.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("UserInfo")
	private UserInfo userInfo;

	static class UserInfo {
		@JsonProperty("firstName")
		private String firstName;

		@JsonProperty("lastName")
		private String lastName;

		@JsonProperty("emailUserName")
		private String emailUserName;

		@JsonProperty("emailDomain")
		private String emailDomain;

		@JsonProperty("password")
		private String password;

		@JsonProperty("dobDate")
		private String dobDate;

		@JsonProperty("dobMonth")
		private String dobMonth;

		@JsonProperty("dobYear")
		private String dobYear;

		@JsonProperty("companyName")
		private String company;
	}

	public String getFirstName() {
		return userInfo.firstName;
	}

	public String getLastName() {
		return userInfo.lastName;
	}

	public String getEmailUserName() {
		return userInfo.emailUserName;
	}

	public String getEmailDomain() {
		return userInfo.emailDomain;
	}

	public String getPassword() {
		return userInfo.password;
	}

	public String getDobDate() {
		return userInfo.dobDate;
	}

	public String getDobMonth() {
		return userInfo.dobMonth;
	}

	public String getDobYear() {
		return userInfo.dobYear;
	}

	public String getCompany() {
		return userInfo.company;
	}

}
