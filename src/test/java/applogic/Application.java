package applogic;


import com.jayway.restassured.response.Response;
import model.City;
import model.formap.Summary;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import static com.jayway.restassured.RestAssured.get;
import static utils.EnvironmentUtil.getAppKey;
import static utils.EnvironmentUtil.getBaseUrl;

public class Application {

    private static final String baseUrl = getBaseUrl();
    private static final String appId = getAppKey();


    public Response getWeatherResponseByCityName(City city) {
        return  get(baseUrl+"/weather?q="+city.name+"&appid="+appId);
    }

    public Response getWeatherResponseByCityId(City city) {
        return  get(baseUrl+"/weather?id="+city.id+"&appid="+appId);
    }

    public Response getFewWeatherResponsesByCityIds(List<City> cities){
        List<String>ids= new ArrayList<>();
        for (City city : cities){
            String id = city.id.toString();
            ids.add(id);
        }
        String query = StringUtils.join(ids, ",");
        return  get(baseUrl+"/group?id="+query+"&units=metric&appid="+appId);
    }

    public Summary getWeatherResponseAsObject(Response response){
        return response.as(Summary.class);
    }
}
