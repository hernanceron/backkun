package com.everis.ecnf.project.generator.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformFileInfo {

    private String template;
    private File output;

}
