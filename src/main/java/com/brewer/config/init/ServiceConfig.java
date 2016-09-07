package com.brewer.config.init;

import com.brewer.services.CervejaService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CervejaService.class)
public class ServiceConfig {


}
