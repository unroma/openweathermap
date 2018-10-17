package utils;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class TestConfiguration {
    private static Configuration configuration;

    private static Configuration initializeConfigurationFiles(){
        Parameters params = new Parameters();
        File propertiesFile = new File("src/test/resources/env.properties");
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
                PropertiesConfiguration.class).configure(params.fileBased().setFile(propertiesFile));
        try {
            return builder.getConfiguration();
        }
        catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Configuration getConfiguration() {
        if (configuration == null) {
            return initializeConfigurationFiles();
        }
        return configuration;
    }
}
