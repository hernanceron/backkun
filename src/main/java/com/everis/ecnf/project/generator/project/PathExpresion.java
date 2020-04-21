package com.everis.ecnf.project.generator.project;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PathExpresion {

    String name;
    String pattern;
    String operator;


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathExpresion that = (PathExpresion) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pattern, that.pattern) &&
                Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pattern, operator);
    }
}
