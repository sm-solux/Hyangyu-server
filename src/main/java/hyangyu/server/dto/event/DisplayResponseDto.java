package hyangyu.server.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisplayResponseDto {
    int status;
    DisplayDto data;
}
