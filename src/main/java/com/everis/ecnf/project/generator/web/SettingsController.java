package com.everis.ecnf.project.generator.web;

import com.everis.ecnf.project.generator.settings.model.DependencyModel;
import com.everis.ecnf.project.generator.settings.model.TypeDomainService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.ecnf.project.generator.settings.business.DependencyService;
import com.everis.ecnf.project.generator.settings.business.TypeProjectService;
import com.everis.ecnf.project.generator.settings.model.TypeProjectModel;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("${application.ecnf.api.path}")
@Slf4j
@Api(tags = "code-domain", description  = "Info sobre dominio de servicio y negocio")
public class SettingsController {

    @Autowired
    DependencyService dependencyService;

    @Autowired
    TypeProjectService typeProjectService;

    @GetMapping(value = "/types/projects", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<TypeProjectModel> getProjects() throws IOException {
        return typeProjectService.getTypeProjects();

    }

    @GetMapping(value = "/types/domain/services", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<TypeDomainService> getDomainServices() throws IOException {
        return null;
    }


    @GetMapping(value = "/types/domain/business", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<TypeDomainService> getDomainBusiness() throws IOException {
        return null;
    }

    @GetMapping(value = "/types/dependencies", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<DependencyModel> getDependencies() throws IOException {
        return dependencyService.getDependency();

    }
}