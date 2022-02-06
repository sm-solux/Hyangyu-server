package hyangyu.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDto {
    String photo;
    String username;
    int score;
    String content;
}
