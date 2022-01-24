package hyangyu.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveFavoriteResponseDto {
    int status;
    String message;
}
