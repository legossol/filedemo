package kr.legossol.protofile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import kr.legossol.protofile.domain.dto.FIleDto;
import kr.legossol.protofile.domain.dto.ReqFileInfo;
import kr.legossol.protofile.domain.dto.ResFileInfo;
import kr.legossol.protofile.exception.FileRequestFileNotException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{

    private final ObjectMapper objectMapper;
    private final LocalFileService localFileService;


    @Override
    public List<FIleDto> saveFile(String params, MultipartFile[] files) {
        ReqFileInfo fileInfo = null;
        try {
            fileInfo = objectMapper.readValue(params, ReqFileInfo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if(files.length == 0 )throw new FileRequestFileNotException("File Not Exception");


        FIleDto fileInstance = FIleDto.getInstance();
        fileInstance.setCategory(fileInfo.getCategory());
        fileInstance.setEnrolledUserId(fileInfo.getRequestUserId());

        List<FIleDto> allFiles = new ArrayList<>();
//        List<FIleDto> resource = files.str
//        for (MultipartFile file : files) {
//            file
//        }

        return null;
    }

    @Override
    public List<ResFileInfo> saveFileList(String params, List<MultipartFile> files) {
        List<Resource> resources = files.stream()
            .map(this.localFileService::copyMultipartFile)
            .collect(Collectors.toList());
        return null;
    }
}
