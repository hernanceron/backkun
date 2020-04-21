package com.everis.ecnf.project.generator.project;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.everis.ecnf.project.generator.project.model.TransformFileInfo;
import com.everis.ecnf.project.generator.config.ApplicationProperties;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ProcesorPath {

    @Autowired
    ApplicationProperties properties;

    private final String PATHVAR = "\\{[a-zA-Z]+\\?*[a-zA-Z]*}";
    private final String OPVAR = "\\?";

    public Collection<TransformFileInfo> collectTransformInfo(String rootDirTpl,
                                                              String sDir,
                                                              File outputDir,
                                                              HashMap<String, Object> props) throws IOException {

    File dirTpl = new File(rootDirTpl +"/"+sDir);
        if (dirTpl.exists() && dirTpl.isDirectory()) {

            return FileUtils.listFiles(dirTpl, new String[]{properties.getExtensionTpl()}, true)
                    .stream()
                    .filter((fileTpl) -> !fileTpl.isDirectory())
                    .map((fileTpl) -> filename(dirTpl.getPath(), sDir, fileTpl , outputDir, props,"\\$", properties.getExtensionTpl()))
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("NO EXIST FOLDER TEMPLATE " + dirTpl);
        }

    }

    private TransformFileInfo filename(String rootPath,
                                                                                   String sourceDir,
                                                                                   File fileTpl,
                                                                                   File outputDir,
                                                                                   HashMap<String, Object> props,
                                                                                   String prefix,
                                                                                   String extTpl) {
        HashMap<String, String> vars = new HashMap<>();
        String filenameTpl = fileTpl.getPath().replace(rootPath,"");
        String newname = new String(filenameTpl);

        Pattern reg = Pattern.compile(prefix+"\\{[a-zA-Z]+\\?*[a-zA-Z]*}");
        Matcher matcher = reg.matcher(filenameTpl);
        while (matcher.find()) {
            String pattern = filenameTpl.substring(matcher.start(), matcher.end());
            String namevar = filenameTpl.substring(matcher.start() + 2, matcher.end() - 1);
            vars.put(namevar, pattern);
        }
        for (String key : vars.keySet()) {
            String []info = key.split("\\?");
            String realkey = info[0];
            String transfor = info.length>1?info[1]:null;
            if (props.containsKey(realkey)) {
                String pattern = vars.get(key);
                String value = props.get(realkey).toString().replace(".", "/");
                value = transform(transfor,value);
                newname = newname.replace(pattern, value);
            } else {
                log.error("NOT FOUND VALUES FOR PATTERS {}", vars.get(key));
            }
        }
        String template = sourceDir+ "/" + filenameTpl;
        String extension = extTpl!=null && !extTpl.isEmpty()?"."+ extTpl:"";
        File output = FileUtils.getFile(outputDir, newname.replace(extension,""));
        return new TransformFileInfo(template, output);
    }

    private String transform(String op, String value){
        if(op!=null) {
            TypPathOp pathOp = TypPathOp.valueOf(op);

            switch (pathOp) {
                case lowercase:
                    return lowercase(value);
                case uppercase:
                    return uppercase(value);
                case capitalize:
                    return capitalize(value);
                default:
                    return value;
            }
        }else {
            return value;
        }
    }

    private String uppercase(String original){
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.toUpperCase();
    }

    private String lowercase(String original){
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.toLowerCase();
    }

    private String capitalize(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

}
