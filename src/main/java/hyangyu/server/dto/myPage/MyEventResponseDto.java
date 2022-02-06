package hyangyu.server.dto.myPage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyEventResponseDto {
    int status;
    MyEventDto data;
}
