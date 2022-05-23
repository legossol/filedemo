package kr.legossol.protofile.domain.dto;

import kr.legossol.protofile.domain.entity.FileCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReqFileInfo {

    private FileCategory category;
    private Long requestUserId;


}
