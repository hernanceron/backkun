package com.everis.ecnf.project.generator.ocp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.everis.ecnf.project.generator.ocp.model.pod.PodInfo;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PodResponse implements Serializable {
    private List<PodInfo> items;
    private String status;
}





