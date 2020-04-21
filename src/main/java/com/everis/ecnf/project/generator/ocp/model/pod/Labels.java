package com.everis.ecnf.project.generator.ocp.model.pod;

import lombok.Data;

@Data
public class Labels {

    private String app;
    //private String pod - template - hash;
    private String version;


}
