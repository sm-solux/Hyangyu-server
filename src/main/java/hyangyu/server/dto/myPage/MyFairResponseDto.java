package hyangyu.server.dto.myPage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyFairResponseDto {
    int status;
    MyFairDto data;
}
