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
public class Festival {

    @Id
    @GeneratedValue
    private Long festivalId;

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

    private String holiday;

    @NotNull
    private String content;

    @NotNull
    private String photo1;

    private String photo2;

    private String photo3;

    @NotNull
    private int price;

    //생성 메서드
    public static Festival createFestival(EventDto eventDto) {
        Festival festival = new Festival();
        festival.startDate = eventDto.getStartDate();
        festival.endDate = eventDto.getEndDate();
        festival.title = eventDto.getTitle();
        festival.likey = eventDto.getLikey();
        festival.reviews = eventDto.getReviews();
        festival.weekdayOpen = eventDto.getWeekdayOpen();
        festival.weekdayClose = eventDto.getWeekdayClose();
        festival.weekendOpen = eventDto.getWeekendOpen();
        festival.weekendClose = eventDto.getWeekendClose();
        festival.location = eventDto.getLocation();
        festival.site = eventDto.getSite();
        festival.holiday = eventDto.getHoliday();
        festival.content = eventDto.getContent();
        festival.photo1 = eventDto.getPhoto1();
        festival.photo2 = eventDto.getPhoto2();
        festival.photo3 = eventDto.getPhoto3();
        festival.price = eventDto.getPrice();

        return festival;
    }

}
