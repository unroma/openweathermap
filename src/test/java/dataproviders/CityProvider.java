package dataproviders;

import model.City;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.List;

public class CityProvider {
    @DataProvider(name = "cityProvider")
    public static Object[] initCities(){

        List<Object> cityList = new ArrayList<>();
        {
            City city = new City()
                    .setName("Moscow")
                    .setId(524901);
            cityList.add(city);
        }

        {
            City city = new City()
                    .setName("London")
                    .setId(2643743);
            cityList.add(city);
        }
        return cityList.toArray();
    }

}
