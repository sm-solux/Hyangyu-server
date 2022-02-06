package hyangyu.server.dto.myPage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyDisplayResponseDto {
    int status;
    MyDisplayDto data;
}
