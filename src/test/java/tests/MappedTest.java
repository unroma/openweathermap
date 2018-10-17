package tests;

import com.jayway.restassured.response.Response;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import model.City;
import model.formap.Summary;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Feature("Test for known response. Response mapped with java objects")
public class MappedTest extends TestBase {

    @Test(description = "Test checks weather description")
    @Description("Test simply gets data by city name and checks if weather description is:light intensity drizzle." +
            "Recommended to use with fake endpoint(mock in properties file) and fake key ")
    public void getWeatherDescriptionTest() {
        City city = new City().setName("London");
        Response response = app.getWeatherResponseByCityName(city);

        Summary all =  app.getWeatherResponseAsObject(response);
        assertEquals(all.weather.get(0).description,"light intensity drizzle");
    }
}
