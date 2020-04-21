package com.everis.ecnf.project.generator.settings.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class TypeProjectModel {

    private String name;
    private String prefix;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
