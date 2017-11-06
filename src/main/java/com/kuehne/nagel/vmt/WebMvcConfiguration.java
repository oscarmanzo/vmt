package com.kuehne.nagel.vmt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc
@Configuration
@ComponentScan("com.kuehne.nagel.vmt")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.jsf");
        registry.addViewController("/home").setViewName("home.jsf");
        registry.addViewController("/error").setViewName("home.jsf");
        registry.addViewController("/403").setViewName("403.jsf");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/");
        bean.setSuffix(".jsf");
        return bean;
    }
}