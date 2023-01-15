package org.webstar.Utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class RandomUser {
    static Faker faker = new Faker();

    public static String getEmail(){
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-gb"),new RandomService());
        String email = fakeValuesService.bothify("??????##@siyamail.com");

        return  email;

    }

    public static String  getName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return  faker.name().lastName();
    }


}
