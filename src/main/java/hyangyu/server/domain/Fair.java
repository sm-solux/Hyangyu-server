package hyangyu.server.domain;

import hyangyu.server.dto.EventDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fair {

    @Id
    @GeneratedValue
    private Long fairId;

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
