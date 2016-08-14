package com.brewer.config.init;

import com.brewer.controller.CervejasController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackageClasses = { CervejasController.class })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {


}
