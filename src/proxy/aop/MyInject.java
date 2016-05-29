package proxy.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.TYPE,ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MyInject {
	public abstract String value() default "";
}
