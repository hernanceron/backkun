package com.everis.ecnf.project.generator.ocp.model.pod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Metadata {
    private String name;

    @JsonIgnore
    private String generateName;
    private String namespace;

    @JsonIgnore
    private String selfLink;

    @JsonIgnore
    private String uid;

    @JsonIgnore
    private String resourceVersion;

    private String creationTimestamp;


    private Labels labels;
    //Annotations annotations;

    @JsonIgnore
    ArrayList<OwnerReferences> ownerReferences = new ArrayList <OwnerReferences> ();


}
