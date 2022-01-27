package hyangyu.server.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
public class EventDto {
    private String title;
    private Date startDate;
    private Date endDate;
    private Time weekdayOpen;
    private Time weekdayClose;
    private Time weekendOpen;
    private Time weekendClose;
    private String location;
    private String site;
    private Date holiday;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;
    private int price;
    private boolean isSaved;
    private List<ReviewDto> reviews;

}


