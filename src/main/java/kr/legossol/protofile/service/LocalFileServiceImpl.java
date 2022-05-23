package kr.legossol.protofile.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
@RequiredArgsConstructor
public class LocalFileServiceImpl implements LocalFileService{

    @Override
    public Resource copyMultipartFile(MultipartFile multipartFile) {
        try{
            Path filePath = Paths.get(
                "/Users/janghaesol/omclog" + File.separator + StringUtils.cleanPath(
                    multipartFile.getOriginalFilename()));
//                getFolderPath()
//                .resolve(
//                Objects.requireNonNull(multipartFile.getOriginalFilename()));
            Files.copy(multipartFile.getInputStream(), filePath);
            return new PathResource(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private Path getFolderPath() throws IOException {
        Path copyLocation = Paths.get("/Users/janghaesol/omclog");
        return copyLocation;
//        Path folderPath = createFolderPath();
//        if (!Files.isDirectory(folderPath)) {
//            Files.createDirectories(folderPath);
//        }
//        return folderPath;
    }

    private Path createFolderPath() {
        String id = MDC.get("id");

        return Paths.get("./tmpfiles", Objects.nonNull(id) ? id : "temp");
    }
}
