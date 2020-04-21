package com.everis.ecnf.project.generator.ocp.model;

import lombok.Data;
import com.everis.ecnf.project.generator.ocp.model.route.RouteInfo;

import java.util.List;

@Data
public class RouteResponse {

    private List<RouteInfo> items;
    private String status;
}
