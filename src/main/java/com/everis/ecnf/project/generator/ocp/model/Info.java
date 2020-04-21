package com.everis.ecnf.project.generator.ocp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Info implements Serializable {

    private String name;
    private String status;
    private String app;
    private String route;



}
