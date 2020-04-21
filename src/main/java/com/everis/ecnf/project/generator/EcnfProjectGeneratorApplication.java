package com.everis.ecnf.project.generator;

import com.pacifico.kuntur.core.starter.web.runner.StarterWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableWebMvc
public class EcnfProjectGeneratorApplication extends StarterWebApplication {

	public static void main(String[] args) {
        //ResourceTemplateInstall.installTemplate();
		SpringApplication.run(EcnfProjectGeneratorApplication.class, args);
	}

}
