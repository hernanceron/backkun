package com.everis.ecnf.project.generator.ocp.model.route;

import lombok.Data;

@Data
public class Metadata {
    private String name;
    private String namespace;
    private String selfLink;
    private String uid;
    private String resourceVersion;
    private String creationTimestamp;
    private Labels labels;
    private Annotations annotations;
}
