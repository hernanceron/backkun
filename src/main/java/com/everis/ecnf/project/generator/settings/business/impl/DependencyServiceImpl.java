package com.everis.ecnf.project.generator.settings.business.impl;

import com.everis.ecnf.project.generator.settings.business.DependencyService;
import com.everis.ecnf.project.generator.settings.model.DependencyModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DependencyServiceImpl implements DependencyService {

    @Override
    public List<DependencyModel> getDependency(){
        List<DependencyModel> result = new ArrayList<>();
        DependencyModel dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-logstash-logback");
        result.add(dependencyModel);

        dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-ws");
        result.add(dependencyModel);

        dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-host");
        result.add(dependencyModel);

        dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-test");
        result.add(dependencyModel);

        dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-hazelcast");
        result.add(dependencyModel);

        dependencyModel = new DependencyModel();
        dependencyModel.setGroup("com.everis.ecnf");
        dependencyModel.setArtifact("ecnf-core-starter-web");
        result.add(dependencyModel);

        return result;
    }
}


