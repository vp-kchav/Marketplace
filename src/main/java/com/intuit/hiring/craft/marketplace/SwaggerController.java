package com.intuit.hiring.craft.marketplace;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


public class SwaggerController extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
          .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
