package kr.legossol.protofile.service;

import java.util.List;
import kr.legossol.protofile.domain.dto.FIleDto;
import kr.legossol.protofile.domain.dto.ResFileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    List<FIleDto> saveFile(String params, MultipartFile[] files);

    List<ResFileInfo> saveFileList(String params, List<MultipartFile> files);

}
