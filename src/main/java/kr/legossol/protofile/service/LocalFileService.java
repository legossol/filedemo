package kr.legossol.protofile.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface LocalFileService {

    Resource copyMultipartFile(MultipartFile multipartFile);
}
