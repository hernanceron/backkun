package com.everis.ecnf.project.generator.web;


import com.everis.ecnf.project.generator.config.Constants;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.everis.ecnf.project.generator.project.business.impl.GeneratorServiceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("${application.ecnf.api.path}")
@Slf4j
@Api(tags = "project", description  = "/")
@CrossOrigin
public class ProjectController {

    @Autowired
    private GeneratorServiceImpl service;

    @PostMapping(value = "/projects", produces="application/zip")
    public ResponseEntity<Resource> getProjects(@RequestBody  HashMap<String,Object> props) throws Exception {
        String a = Constants.pathTemplate;
        //ResourceTemplateInstall.installTemplate();

        String numBuild = new Date().getTime()+"";
        props.put("dependencies", this.dependencies());
        service.build(props, numBuild + "/" +props.get("outputdir").toString(), props.get("maintemplate").toString(), a);

        for(HashMap<String, Object> map : ((List<HashMap<String,Object>>) props.get("fragment")) ) {
            HashMap<String,Object> props2 = new HashMap<>();
            props2.putAll(props);
            props2.putAll(map);

            Object outputdir = numBuild + "/" + props2.get("outputdir");
            Object fragmdir = props2.get("maintemplate");
            service.build(props2, outputdir.toString(), "FRAGMENT/"+fragmdir.toString(), a);

        }

        ZipFile out = service.dist(numBuild, numBuild + "/" +props.get("outputdir").toString(), "dist");

        //return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename='"+ numBuild + ".zip'" ).body(new FileSystemResource(out.getFile()));
        return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"pacifico.zip\"")
                .header("Content-Type","application/zip")
                .body(new FileSystemResource(out.getFile()));
    }

    public List<HashMap<String,String>> dependencies(){
        return Arrays.asList(
                dependency("com.everis.ecnf","ecnf-core-starter-web", "1.0.0-SNAPSHOT"),
                dependency("com.everis.ecnf", "ecnf-core-starter-hazelcast", "1.0.0-SNAPSHOT")
                );
    }

    public HashMap<String,String> dependency(String group, String artifactid, String version){
        HashMap<String,String> depen = new HashMap<>();
        depen.put("groupId",group);
        depen.put("artifactId",artifactid);
        if(version!=null){
            depen.put("version",version);
        }
        return depen;
    }

}
