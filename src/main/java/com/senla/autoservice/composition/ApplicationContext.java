package com.senla.autoservice.composition;

import com.senla.autoservice.composition.annotations.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private ObjectFactory factory;
    private Map<Class, Object> cache = new ConcurrentHashMap<>();
    private IConfig config;

    public ApplicationContext(IConfig iConfig) {
        this.config = iConfig;
    }

    public <T> T getObject(Class<T> type) throws ReflectiveOperationException {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }

    public void setFactory(ObjectFactory factory) {
        this.factory = factory;
    }

    public IConfig getConfig() {
        return config;
    }
}
