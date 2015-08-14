package com.beauty.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: Need
 * @Description: TODO(用于判断一个类中属性在该使用时必需)
 * @author frinder_liu
 * @date 2015年8月13日 上午10:17:04
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Orderable {

	public String columnName() default "";

}
