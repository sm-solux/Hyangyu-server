package hyangyu.server.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FairResponseDto {
    int status;
    FairDto data;
}
