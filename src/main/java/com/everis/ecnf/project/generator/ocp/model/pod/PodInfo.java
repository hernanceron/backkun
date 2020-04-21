package com.everis.ecnf.project.generator.ocp.model.pod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PodInfo {
    Metadata metadata;
    @JsonIgnore
    Spec spec;
    Status status;

}
