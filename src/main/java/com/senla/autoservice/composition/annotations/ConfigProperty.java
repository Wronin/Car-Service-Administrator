package com.senla.autoservice.composition.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {
    public String ConfigName() default "resources/config.properties";
    public String PropertyName();
    public Class classType() default Object.class;
}
