package com.everis.ecnf.project.generator.ocp.model.pod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Status {
    private String phase;
    @JsonIgnore
    ArrayList<Object> conditions = new ArrayList<Object>();
    private String hostIP;
    private String podIP;
    private String startTime;
    @JsonIgnore
    ArrayList <Object> containerStatuses = new ArrayList <Object> ();
    @JsonIgnore
    private String qosClass;


}
