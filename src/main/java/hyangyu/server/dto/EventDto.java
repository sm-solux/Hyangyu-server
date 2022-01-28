package hyangyu.server.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
public class EventDto {
    private Date startDate;
    private Date endDate;
    private String title;
    private int likey;
    private int reviews;
    private Time weekdayOpen;
    private Time weekdayClose;
    private Time weekendOpen;
    private Time weekendClose;
    private String location;
    private String site;
    private String holiday;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;
    private int price;
}


