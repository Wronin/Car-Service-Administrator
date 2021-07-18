package com.senla.autoservice.composition.annotations.configurations;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.composition.annotations.ConfigProperty;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigureProperty implements ObjectConfigurator{

    @Override
    public void configure(Object t, ApplicationContext context) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ReflectiveOperationException, IOException {
        Class<?> implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            ConfigProperty configProperty = field.getDeclaredAnnotation(ConfigProperty.class);
            field.setAccessible(true);

            if (configProperty != null) {
                File file = new File("src/main/resources/config.properties");

                Properties properties = new Properties();
                properties.load(new FileReader(file));

                String propertyValue = properties.getProperty(configProperty.PropertyName());

                if (configProperty.classType().equals(Integer.class))
                    field.set(t,  Integer.parseInt(propertyValue));
                else if (configProperty.classType().equals(Boolean.class))
                    field.set(t,  Boolean.parseBoolean(propertyValue));
                else if (configProperty.classType().equals(Float.class))
                    field.set(t, Float.parseFloat(propertyValue));
//                else if (configProperty.classType().equals(Serializator.class))
//                    field.set(t, Class.forName(propertyValue).newInstance());
                else
                    field.set(t, propertyValue);
            }
        }
    }

}
