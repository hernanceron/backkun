package com.everis.ecnf.project.generator.config;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Slf4j
@Configuration
public class TemplateConfiguration {

    @Bean
    public freemarker.template.Configuration freeMarkerConfiguration() throws IOException
    {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration();
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        //cfg.setLogTemplateExceptions(true);
        cfg.setTemplateLoader(new FileTemplateLoader(new File(Constants.pathTemplate)));
        return cfg;
    }



}
