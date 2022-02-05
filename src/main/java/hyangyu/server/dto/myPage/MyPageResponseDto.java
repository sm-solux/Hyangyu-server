package hyangyu.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyPageResponseDto {

    int status;
    MyPageDto data;
    /*

    orderBy endDate
     */
    static class MyPageDto {
        String photo;
        String username;
        List<EventDto> displays;
    }

}