package org.example.resfulapi.restfulapibooks.Helper;

import org.hibernate.annotations.Comment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

   // public  final String upload_DIR="/home/haroon/Documents/Spring boot/RestfulApiBooks/src/main/resources/static/Images/";
    public  final String upload_DIR=new ClassPathResource("static/Images").getFile().getAbsolutePath();
public FileUploadHelper() throws IOException {

}

public boolean uploadFile(MultipartFile multipartFile) {

boolean result = false;
    try{
        /*    InputStream is = multipartFile.getInputStream();
byte []data = new byte[is.available()];

is.read(data);


       FileOutputStream fos = new FileOutputStream(new File(upload_DIR+ File.separator+multipartFile.getOriginalFilename()));

        fos.write(data);
        fos.flush();
        fos.close();
result = true;*/

        Files.copy(multipartFile.getInputStream(), Paths.get(upload_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
result = true;

    }catch (Exception e){
        e.printStackTrace();
    }
return result;
}


}
