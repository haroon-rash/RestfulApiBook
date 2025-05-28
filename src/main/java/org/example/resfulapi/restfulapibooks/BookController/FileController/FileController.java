package org.example.resfulapi.restfulapibooks.BookController.FileController;

import org.example.resfulapi.restfulapibooks.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {


    @Autowired
    private FileUploadHelper fupload;

@PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

try{

    //Validation
  if(file.isEmpty()){
        return ResponseEntity.badRequest().body("Empty file");
    }

    if(!file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")){
        return ResponseEntity.badRequest().body("Wrong file type only Jpeg is Allowed");
    }


    //Upload File


   boolean b=fupload.uploadFile(file);
if(b){
    return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Images/").path(file.getOriginalFilename()).toUriString());
}
else
    return ResponseEntity.badRequest().body("File upload failed");
}
catch(Exception e){
return ResponseEntity.badRequest().body("File upload failed");
}

}
}
