/*
 * Copyright (c) 2013 Qunar.com. All Rights Reserved.
 */

package vine.core.dao.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author maolin.luo created on 2013-12-30 上午10:52:38
 * @version 1.0.0
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoDao {

}
