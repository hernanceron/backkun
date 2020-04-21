package com.everis.ecnf.project.generator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ApplicationProperties {

    @Value("${ext-tpl:ftlx}")
    private String extensionTpl;

    @Value("${ext-tpl:zip}")
    private String extensionZip;


    @Value("${tmp-dir:/tmp/000/}")
    private String tmpDirectory;

    @Value("${tmp-dir:/tmp/000/template/}")
    private String tmpTemplateDirectory;

    @Value("${tmp-dir:/tmp/000/build/}")
    private String tmpBuildDirectory;

    @Value("${tmp-dir:/tmp/000/dist/}")
    private String tmpZipDirectory;

    public String getExtensionTpl() {
        return extensionTpl;
    }

    public void setExtensionTpl(String extensionTpl) {
        this.extensionTpl = extensionTpl;
    }

    public String getExtensionZip() {
        return extensionZip;
    }

    public void setExtensionZip(String extensionZip) {
        this.extensionZip = extensionZip;
    }

    public String getTmpDirectory() {
        return tmpDirectory;
    }

    public void setTmpDirectory(String tmpDirectory) {
        this.tmpDirectory = tmpDirectory;
    }

    public String getTmpTemplateDirectory() {
        return tmpTemplateDirectory;
    }

    public void setTmpTemplateDirectory(String tmpTemplateDirectory) {
        this.tmpTemplateDirectory = tmpTemplateDirectory;
    }

    public String getTmpBuildDirectory() {
        return tmpBuildDirectory;
    }

    public void setTmpBuildDirectory(String tmpBuildDirectory) {
        this.tmpBuildDirectory = tmpBuildDirectory;
    }

    public String getTmpZipDirectory() {
        return tmpZipDirectory;
    }

    public void setTmpZipDirectory(String tmpZipDirectory) {
        this.tmpZipDirectory = tmpZipDirectory;
    }
}
