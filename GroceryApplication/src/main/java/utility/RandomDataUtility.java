package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility 
{
Faker faker=new Faker();
public String randomUserName() 
{
	return faker.name().username();
}
public String randomPasswordName()
{
	return faker.internet().password();
}
public String fullName()
{
	return faker.name().fullName();
}
public String email()
{
	return faker.internet().emailAddress();
}
public String mobileNumber()
{
	return faker.phoneNumber().cellPhone();
}
}
