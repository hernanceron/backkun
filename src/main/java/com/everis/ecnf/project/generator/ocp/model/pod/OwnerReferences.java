package com.everis.ecnf.project.generator.ocp.model.pod;

import lombok.Data;

@Data
public class OwnerReferences {
    private String apiVersion;
    private String kind;
    private String name;
    private String uid;
    private String controller;
    private String blockOwnerDeletion;

}
