package hyangyu.server.domain;

import hyangyu.server.dto.EventDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Display {

    @Id
    @GeneratedValue
    private Long displayId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String title;

    private int likey;

    private int reviews;

    @NotNull
    private Time weekdayOpen;

    @NotNull
    private Time weekdayClose;

    @NotNull
    private Time weekendOpen;

    @NotNull
    private Time weekendClose;

    @NotNull
    private String location;

    @NotNull
    private String site;

    private Date holiday;

    @NotNull
    private String content;

    @NotNull
    private String photo1;

    private String photo2;

    private String photo3;

    @NotNull
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
