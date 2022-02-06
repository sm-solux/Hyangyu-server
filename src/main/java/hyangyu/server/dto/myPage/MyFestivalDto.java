package hyangyu.server.dto.myPage;

import hyangyu.server.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFestivalDto {
    private List<EventDto> festivals;
}
