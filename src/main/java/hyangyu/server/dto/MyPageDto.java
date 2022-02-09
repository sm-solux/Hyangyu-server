package hyangyu.server.dto.event;

import hyangyu.server.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDto {
    private String image;
    private String username;
    private List<EventDto> displays;

    public MyPageDto(List<EventDto> displays) {
        this.displays = displays;
    }
}
