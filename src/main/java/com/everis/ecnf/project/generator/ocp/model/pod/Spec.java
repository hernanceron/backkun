package com.everis.ecnf.project.generator.ocp.model.pod;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Spec {

    @JsonIgnore
    ArrayList< Object > volumes = new ArrayList < Object > ();
    ArrayList < Object > containers = new ArrayList < Object > ();

    @JsonIgnore
    private String restartPolicy;

    @JsonIgnore
    private float terminationGracePeriodSeconds;
    @JsonIgnore
    private String dnsPolicy;
    @JsonIgnore
    NodeSelector nodeSelector;

    @JsonIgnore
    private String serviceAccountName;


    @JsonIgnore    private String serviceAccount;
    private String nodeName;

    @JsonIgnore
    SecurityContext securityContext;

    @JsonIgnore
    ArrayList < Object > imagePullSecrets = new ArrayList < Object > ();

    @JsonIgnore
    private String schedulerName;

    @JsonIgnore
    ArrayList < Object > tolerations = new ArrayList < Object > ();

    @JsonIgnore
    private float priority;
}
