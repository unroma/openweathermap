package tests;


import dataproviders.CityProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import model.City;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;



@Feature("Simple default test class. Only to show possible approach.")
public class SimpleTest extends TestBase {

    @Test(dataProvider = "cityProvider", dataProviderClass = CityProvider.class)
    @Description("Parametrized test, gets two objects from data provider")
    public void requestByCityNameTest(City city) {
        app.getWeatherResponseByCityName(city)
                .then().statusCode(200)
                .body("id",equalTo(city.id))
                .body("name",equalTo(city.name));
    }

    @Test
    @Description("Simple,shallow test. Also could be easily parametrized ")
    public void requestByCityIdTest() {
        City city = new City().setName("London").setId(2643743);

        app.getWeatherResponseByCityId(city)
                .then().statusCode(200)
                .body("id",equalTo(city.id))
                .body("name",equalTo(city.name));
    }

    @Test
    @Description("Simple,shallow test ")
    public void requestByFewCityIdsTest() {
        City city1 = new City().setName("London").setId(2643743);
        City city2 =  new City().setName("Moscow").setId(524901);
        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        app.getFewWeatherResponsesByCityIds(cities)
                .then().statusCode(200)
                .body(containsString(city1.name)).and().body(containsString(city2.name));
    }
}
