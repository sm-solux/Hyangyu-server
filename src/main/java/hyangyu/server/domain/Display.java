package hyangyu.server.domain;

import hyangyu.server.dto.EventDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Display {

    @Id
    @GeneratedValue
    private Long displayId;

    @NotEmpty
    private Date startDate;

    @NotEmpty
    private Date endDate;

    @NotEmpty
    private String title;

    private int likey;

    private int reviews;

    @NotEmpty
    private Time weekdayOpen;

    @NotEmpty
    private Time weekdayClose;

    @NotEmpty
    private Time weekendOpen;

    @NotEmpty
    private Time weekendClose;

    @NotEmpty
    private String location;

    @NotEmpty
    private String site;

    private Date holiday;

    @NotEmpty
    private String content;

    @NotEmpty
    private String photo1;

    private String photo2;

    private String photo3;

    @NotEmpty
    private int price;

    //생성 메서드
    public static Display createDisplay(EventDto eventDto) {
        Display display = new Display();
        display.startDate = eventDto.getStartDate();
        display.endDate = eventDto.getEndDate();
        display.title = eventDto.getTitle();
        display.likey = eventDto.getLikey();
        display.reviews = eventDto.getReviews();
        display.weekdayOpen = eventDto.getWeekdayOpen();
        display.weekdayClose = eventDto.getWeekdayClose();
        display.weekendOpen = eventDto.getWeekendOpen();
        display.weekendClose = eventDto.getWeekendClose();
        display.location = eventDto.getLocation();
        display.site = eventDto.getSite();
        display.holiday = eventDto.getHoliday();
        display.content = eventDto.getContent();
        display.photo1 = eventDto.getPhoto1();
        display.photo2 = eventDto.getPhoto2();
        display.photo3 = eventDto.getPhoto3();
        display.price = eventDto.getPrice();

        return display;
    }
}
