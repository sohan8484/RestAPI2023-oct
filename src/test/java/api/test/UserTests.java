package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import com.github.javafaker.Faker;
import org.junit.Test;

public class UserTests {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setUpData(){
    faker = new Faker();
    userPayload = new User();
    userPayload.setId(faker.idNumber().hashCode());
    userPayload.setUsername(faker.name().username());
    userPayload.setFirstName(faker.name().firstName());
    userPayload.setLastName(faker.name().lastName());
    userPayload.setEmail(faker.internet().safeEmailAddress());
    userPayload.setPassword(faker.internet().password(5,10));
    userPayload.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority=1)
    public void testPostUser(){
        Response res = UserEndpoints.createUser(userPayload);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(),200);
    }
}
