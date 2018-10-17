package utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.lang3.StringUtils;

public class EnvironmentUtil {

    private static final String TEST_ENV = "env";
    private static final String DEFAULT_TEST_ENV = "real";
    private static final String KEY = "key";
    private static final String DEFAULT_KEY = "real_key";

    public static String getBaseUrl() {
        Configuration conf = TestConfiguration.getConfiguration();
        if (StringUtils.isNotEmpty(System.getProperty(TEST_ENV))) {
            return conf.getString(System.getProperty(TEST_ENV));
        }
        return conf.getString(DEFAULT_TEST_ENV);
    }

    public static String getAppKey(){
        Configuration conf = TestConfiguration.getConfiguration();
        if (StringUtils.isNotEmpty(System.getProperty(KEY))) {
            return System.getProperty(KEY);
        }
        return conf.getString(DEFAULT_KEY);
    }
}
