package kr.legossol.protofile.domain.dto;

import java.util.ArrayList;
import java.util.List;
import kr.legossol.protofile.domain.entity.FileCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResFileInfo {
    private long id;

    private long enrolledUserId;
    private FileCategory category;
    private String originalName;
    private String savedName;
    private Long size;
    private String extension;

    public static List<ResFileInfo> toResFileInfo(List<FIleDto> files) {
        List<ResFileInfo> resFileInfos = new ArrayList<>();
        if(files.isEmpty()) return resFileInfos;

        files.forEach(fIleDto ->
            resFileInfos.add(
                ResFileInfo.builder()
                    .id(fIleDto.getId())
                    .enrolledUserId(fIleDto.getEnrolledUserId())
                    .category(fIleDto.getCategory())
                    .originalName(fIleDto.getOriginalName())
                    .savedName(fIleDto.getSavedName())
                    .size(fIleDto.getSize())
                    .extension(fIleDto.getExtension())
                    .build()
            ));
        return resFileInfos;
    }
}
