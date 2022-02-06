package hyangyu.server.dto.myPage;

import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.TestEventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDto {
    String image;
    String username;
    List<EventDto> displays;
    /*
    orderBy endDate
     */

    public MyPageDto(List<EventDto> displays) {
        this.displays = displays;
    }
}
