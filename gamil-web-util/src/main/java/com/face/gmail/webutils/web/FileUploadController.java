package com.face.gmail.webutils.web;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.io.IOException;

@Api("上传下载文件")
@RestController
public class FileUploadController {

    @Autowired
    private ResourceHttpRequestHandler resourceHandler;

    @Autowired
    private FastFileStorageClient storageClient;


    @Value("${fast.file.domain://123.56.16.249:8082/}")
    private String domainName;

    @ApiOperation("需要上传的文件")
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public String uploadFile(MultipartFile filePart) throws IOException {


//        Resource resource = filePart.getResource();
//
//        Path uploadPath = Paths.get(resource.getURI());
//
//        filePart.transferTo(uploadPath);
//        //上传到 fastDfs
//        Files.delete(uploadPath);


//        UrlResource
//        ByteArrayResource resource1 = new ByteArrayResource(filePart.getBytes());

        StorePath storePath = storageClient.uploadFile(filePart.getInputStream(), filePart.getSize(),
                FilenameUtils.getExtension(filePart.getOriginalFilename()), null);

        return domainName + storePath.getFullPath();




    }

}
