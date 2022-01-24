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
    @Builder
    public void createFair(EventDto eventDto) {
        this.startDate = eventDto.getStartDate();
        this.endDate = eventDto.getEndDate();
        this.title = eventDto.getTitle();
        this.likey = eventDto.getLikey();
        this.reviews = eventDto.getReviews();
        this.weekdayOpen = eventDto.getWeekdayOpen();
        this.weekdayClose = eventDto.getWeekdayClose();
        this.weekendOpen = eventDto.getWeekendOpen();
        this.weekendClose = eventDto.getWeekendClose();
        this.location = eventDto.getLocation();
        this.site = eventDto.getSite();
        this.holiday = eventDto.getHoliday();
        this.content = eventDto.getContent();
        this.photo1 = eventDto.getPhoto1();
        this.photo2 = eventDto.getPhoto2();
        this.photo3 = eventDto.getPhoto3();
        this.price = eventDto.getPrice();
    }

}
