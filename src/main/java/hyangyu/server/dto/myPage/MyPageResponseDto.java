package hyangyu.server.dto.myPage;

import hyangyu.server.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyPageResponseDto {

    int status;
    MyPageDto data;

}