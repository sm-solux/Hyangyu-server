package hyangyu.server.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hyangyu.server.domain.*;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.TestEventDto;
import hyangyu.server.dto.myPage.MyEventDto;
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

    public MyEventDto getMyDisplay(Long userId, int page) {

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

        MyEventDto myDisplay = new MyEventDto(displayList);

        return myDisplay;

    }
}
