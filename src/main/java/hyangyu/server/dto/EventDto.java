package hyangyu.server.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Time;

@Data
public class EventDto {
    private Long eventId;
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
    private Date holiday;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;
    private int price;
}
