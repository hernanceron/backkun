package com.everis.ecnf.project.generator.config;

import org.apache.commons.io.FileUtils;
//import com.everis.ecnf.core.constants.ErrorCategory;
//import com.everis.ecnf.core.exception.EcnfException;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.jar.JarFile;


public class ResourceTemplateInstall {


   public  static  void installTemplate(){

       try {
           FileUtils.forceMkdir(new File(Constants.pathTemplate));
           URL url = ResourceTemplateInstall.class.getClassLoader().getResource("/templates");
           URI uri = url.toURI();
           if (uri.getScheme().equals("jar")) {
               // parse JAR file name
               String jarPath = uri.toString().replaceFirst("jar:file:", "").replaceFirst("!.*$", "");
               JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
               java.util.Enumeration enumEntries = jar.entries();
               while (enumEntries.hasMoreElements()) {
                   java.util.jar.JarEntry file = (java.util.jar.JarEntry) enumEntries.nextElement();

                   if(file.getName().startsWith("BOOT-INF/classes/templates")) {
                       String newName  = Constants.pathTemplate + java.io.File.separator + file.getName().replace("BOOT-INF/classes/templates","");
                       System.out.println(newName);
                       java.io.File f = new java.io.File(newName);
                       if (file.isDirectory()) { // if its a directory, create it
                           f.mkdir();
                           continue;
                       }else{

                       }
                       java.io.InputStream is = jar.getInputStream(file); // get the input stream
                       java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
                       while (is.available() > 0) {  // write contents of 'is' to 'fos'
                           fos.write(is.read());
                       }
                       fos.close();
                       is.close();
                   }
               }
               jar.close();

           }
       }catch (Exception e){
           //throw EcnfException.builder().systemCode("GA0001").category(ErrorCategory.UNEXPECTED).build();
       }
   }
}
