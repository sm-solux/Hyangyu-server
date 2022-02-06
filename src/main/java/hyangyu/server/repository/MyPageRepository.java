package hyangyu.server.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hyangyu.server.domain.*;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.myPage.MyDisplayDto;
import hyangyu.server.dto.myPage.MyFairDto;
import hyangyu.server.dto.myPage.MyFestivalDto;
import hyangyu.server.dto.myPage.MyPageDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MyPageRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    QFavoriteDisplay favoriteDisplay = QFavoriteDisplay.favoriteDisplay;
    QFavoriteFair favoriteFair = QFavoriteFair.favoriteFair;
    QFavoriteFestival favoriteFestival = QFavoriteFestival.favoriteFestival;

    public MyPageRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public MyPageDto getMyPage(Long userId) {

        List<Display> displays = queryFactory.select(favoriteDisplay.display)
                .from(favoriteDisplay)
                .where(favoriteDisplay.user.userId.castToNum(Long.class).eq(userId))
                .orderBy(favoriteDisplay.display.endDate.desc())
                .limit(10)
                .fetch();

        List<EventDto> displayList = new ArrayList<>();
        for (Display display : displays) {
            EventDto eventDto = new EventDto(display);
            eventDto.setSaved(true);
            displayList.add(eventDto);
        }

        MyPageDto myPageDto = new MyPageDto(displayList);

        return myPageDto;

    }

    public MyDisplayDto getMyDisplay(Long userId, int page) {

        List<Display> displays = queryFactory.select(favoriteDisplay.display)
                .from(favoriteDisplay)
                .where(favoriteDisplay.user.userId.castToNum(Long.class).eq(userId))
                .orderBy(favoriteDisplay.display.endDate.desc())
                .offset(page*10)
                .limit(10)
                .fetch();

        List<EventDto> displayList = new ArrayList<>();
        for (Display display : displays) {
            EventDto eventDto = new EventDto(display);
            eventDto.setSaved(true);
            displayList.add(eventDto);
        }

        MyDisplayDto myDisplay = new MyDisplayDto(displayList);

        return myDisplay;

    }

    public MyFairDto getMyFair(Long userId, int page) {

        List<Fair> fairs = queryFactory.select(favoriteFair.fair)
                .from(favoriteFair)
                .where(favoriteFair.user.userId.castToNum(Long.class).eq(userId))
                .orderBy(favoriteFair.fair.endDate.desc())
                .offset(page*10)
                .limit(10)
                .fetch();

        List<EventDto> fairList = new ArrayList<>();
        for (Fair fair : fairs) {
            EventDto eventDto = new EventDto(fair);
            eventDto.setSaved(true);
            fairList.add(eventDto);
        }

        MyFairDto myFair = new MyFairDto(fairList);

        return myFair;

    }

    public MyFestivalDto getMyFestival(Long userId, int page) {

        List<Festival> festivals = queryFactory.select(favoriteFestival.festival)
                .from(favoriteFestival)
                .where(favoriteFestival.user.userId.castToNum(Long.class).eq(userId))
                .orderBy(favoriteFestival.festival.endDate.desc())
                .offset(page*10)
                .limit(10)
                .fetch();

        List<EventDto> festivalList = new ArrayList<>();
        for (Festival festival : festivals) {
            EventDto eventDto = new EventDto(festival);
            eventDto.setSaved(true);
            festivalList.add(eventDto);
        }

        MyFestivalDto myFestival = new MyFestivalDto(festivalList);

        return myFestival;

    }
}
