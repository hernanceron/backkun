package com.everis.ecnf.project.generator.project.business.impl;

import com.everis.ecnf.project.generator.config.ApplicationProperties;
import com.everis.ecnf.project.generator.project.ProcesorPath;
import com.everis.ecnf.project.generator.project.business.GeneratorService;
import com.everis.ecnf.project.generator.project.model.TransformFileInfo;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    ApplicationProperties properties;

    @Autowired
    ProcesorPath path;

    @Autowired
    Configuration configuration;

    public GeneratorServiceImpl(ApplicationProperties properties) {
        this.properties = properties;
        this.configuration = configuration;
    }


    /**
     *
     * @param props conjunto de valores para las plantillas
     * @param directoryNameOutput nombre del directorio con la plantilla root
     * @param prefix carpeta con la plantilla especifica
     * @param dirTpl directorio con todas las plantillas
     */
    public void build(final HashMap<String, Object> props, String directoryNameOutput, String prefix, String dirTpl) {
        try {
            File outDir = new File( properties.getTmpBuildDirectory() + "/" + directoryNameOutput);
            FileUtils.forceMkdir(outDir);
            //FileUtils.cleanDirectory(outDir);
            Collection<TransformFileInfo> list = path.collectTransformInfo(dirTpl, prefix,  outDir,  props);
            list.forEach((t) -> {
                try {
                    FileUtils.forceMkdir(t.getOutput().getParentFile());
                    configuration.getTemplate(t.getTemplate()).process(props, new FileWriter(t.getOutput()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param filename
     * @param directoryNameOutput
     * @param nameout
     * @return
     * @throws Exception
     */
    public ZipFile dist(String filename, String directoryNameOutput, String nameout) throws Exception {

        File content = new File( properties.getTmpBuildDirectory() + "/" + directoryNameOutput);
        String outputZip = properties.getTmpBuildDirectory() + "/" + directoryNameOutput + "/" + nameout+ "/";
        FileUtils.forceMkdir(new File(outputZip));
        ZipFile zipFile = new ZipFile(FileUtils.getFile(outputZip, filename+"." + properties.getExtensionZip()));
        ZipParameters parameters = new ZipParameters();
        // set compression method to store compression
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        // Set the compression level─
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        //parameters.setIncludeRootFolder(false);
        zipFile.addFolder(content, parameters);

        return zipFile;
    }

}