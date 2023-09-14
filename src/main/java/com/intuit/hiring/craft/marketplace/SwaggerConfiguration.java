package com.intuit.hiring.craft.marketplace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.intuit.hiring.craft.marketplace"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
      return new InternalResourceViewResolver();
    }
}
