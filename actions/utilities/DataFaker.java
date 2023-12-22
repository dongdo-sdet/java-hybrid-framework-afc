package utilities;

import com.github.javafaker.Faker;

public class DataFaker {
	private Faker faker;

	public DataFaker() {
		faker = new Faker();
	}

	public static DataFaker getDataFaker() {
		return new DataFaker();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public String getCityName() {
		return faker.address().city();
	}

	public String getStateName() {
		return faker.address().state();
	}

	public String getZipCode() {
		return faker.address().zipCode();
	}

	public String getAddressName() {
		return faker.address().streetAddress();
	}

	public String getCompanyName() {
		return faker.company().name();
	}

}
