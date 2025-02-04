package hyangyu.server.dto.event;

import hyangyu.server.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayDto {
    private List<EventDto> displays;
}
