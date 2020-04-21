package com.everis.ecnf.project.generator.ocp.model.pod;

import lombok.Data;

@Data
public class SecurityContext {
    SeLinuxOptions SeLinuxOptionsObject;
    private float fsGroup;


}
