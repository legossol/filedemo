package kr.legossol.protofile.domain.dto;

import kr.legossol.protofile.domain.entity.FileCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FIleDto {

    private long id;

    private long enrolledUserId;
    private FileCategory category;
    private String originalName;
    private String savedName;
    private Long size;
    private String extension;

    public static FIleDto getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

        private static final FIleDto INSTANCE = new FIleDto();
    }


}
