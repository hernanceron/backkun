package com.everis.ecnf.project.generator.settings.business.impl;

import com.everis.ecnf.project.generator.settings.business.TypeProjectService;
import com.everis.ecnf.project.generator.settings.model.TypeProjectModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeProjectServiceImpl implements TypeProjectService {

    @Override
    public List<TypeProjectModel> getTypeProjects() {
        List<TypeProjectModel> models = new ArrayList<>();

        TypeProjectModel model = new TypeProjectModel();
        model.setName("Ecnf Support");
        model.setPrefix("TSB");
        models.add(model);

        model = new TypeProjectModel();
        model.setName("Ecnf Support Channel");
        model.setPrefix("TSC");
        models.add(model);

        model = new TypeProjectModel();
        model.setName("Ecnf Xperience");
        model.setPrefix("TCH");
        models.add(model);

        model = new TypeProjectModel();
        model.setName("Ecnf Support Business");
        model.setPrefix("TSB");
        models.add(model);

        return models;
    }
}
