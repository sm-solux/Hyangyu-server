package hyangyu.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReviewsResponseDto {
    int status;
    List<ReviewDto> data;
}
