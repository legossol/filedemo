package kr.legossol.protofile.controller;

import java.util.List;
import kr.legossol.protofile.domain.dto.FIleDto;
import kr.legossol.protofile.domain.dto.ResFileInfo;
import kr.legossol.protofile.domain.entity.FileCategory;
import kr.legossol.protofile.service.FileService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class MultifileController {

    private final FileService fileService;

    @PostMapping
    public List<FIleDto> getAndSaveFile(
        @RequestParam(name = "params")String params,
        @RequestPart(value = "files") MultipartFile[] files) {
        List<FIleDto> result = fileService.saveFile(params, files);
        return result;
    }
    @PostMapping("/ListVersion")
    public List<ResFileInfo> getAndSaveFileList(
        @RequestParam(name = "params")String params,
        @RequestPart(value = "files") List<MultipartFile> files) {
        List<ResFileInfo> result = fileService.saveFileList(params, files);
        return result;
    }


}
