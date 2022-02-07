package hyangyu.server.dto.myPage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyFestivalResponseDto {
    int status;
    MyFestivalDto data;
}
