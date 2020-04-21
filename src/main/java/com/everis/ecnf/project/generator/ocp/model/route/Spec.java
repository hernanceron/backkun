package com.everis.ecnf.project.generator.ocp.model.route;

import lombok.Data;

@Data
public class Spec {
    private String host;
    To to;
    Port port;
    Tls tls;
    private String wildcardPolicy;


}
