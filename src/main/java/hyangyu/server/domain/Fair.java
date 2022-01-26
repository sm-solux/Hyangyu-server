package hyangyu.server.domain;

import hyangyu.server.dto.EventDto;
import lombok.AccessLevel;
import lombok.Builder;
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
public class Fair {

    @Id
    @GeneratedValue
    private Long fairId;

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
    public static Fair createFair(EventDto eventDto) {
        Fair fair = new Fair();
        fair.startDate = eventDto.getStartDate();
        fair.endDate = eventDto.getEndDate();
        fair.title = eventDto.getTitle();
        fair.likey = eventDto.getLikey();
        fair.reviews = eventDto.getReviews();
        fair.weekdayOpen = eventDto.getWeekdayOpen();
        fair.weekdayClose = eventDto.getWeekdayClose();
        fair.weekendOpen = eventDto.getWeekendOpen();
        fair.weekendClose = eventDto.getWeekendClose();
        fair.location = eventDto.getLocation();
        fair.site = eventDto.getSite();
        fair.holiday = eventDto.getHoliday();
        fair.content = eventDto.getContent();
        fair.photo1 = eventDto.getPhoto1();
        fair.photo2 = eventDto.getPhoto2();
        fair.photo3 = eventDto.getPhoto3();
        fair.price = eventDto.getPrice();

        return fair;
    }

}
