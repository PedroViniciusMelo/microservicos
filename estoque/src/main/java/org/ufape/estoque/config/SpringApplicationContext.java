package org.ufape.estoque.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringApplicationContext {
    private static ApplicationContext CONTEXT;

    public static void setApplicationContext(ApplicationContext context) {
        CONTEXT = context;
    }

    public static Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }
}
