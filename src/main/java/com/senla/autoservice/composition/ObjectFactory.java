package com.senla.autoservice.composition;

import com.senla.autoservice.composition.annotations.configurations.ObjectConfigurator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    public ObjectFactory(ApplicationContext context) throws ReflectiveOperationException {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

//    @SneakyThrows
    public <T> T createObject(Class<T> implClass) throws ReflectiveOperationException {
        T t = create(implClass);
        configure(t);

        return t;

    }

    private <T> void configure(T t) {
        configurators.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t,context);
            } catch (ReflectiveOperationException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    private <T> T create(Class<T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }

}
