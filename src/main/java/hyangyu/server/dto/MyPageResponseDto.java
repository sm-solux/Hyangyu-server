package hyangyu.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyPageResponseDto {

    String photo;
    String username;
    List<EventDto> displays;
    List<EventDto> fairs;
    List<EventDto> festivals;
    List<ReviewDto> reveiws;

    /*

    orderBy endDate
     */

}