package hyangyu.server.repository;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.FavoriteDisplayId;
import hyangyu.server.domain.User;
import hyangyu.server.dto.EventDto;
import org.aspectj.lang.annotation.RequiredTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;

@SpringBootTest
@Transactional
public class FavoriteRepositoryTest {

    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    EntityManager em;

    @Test
    void saveDisplay() {

        //given
        User user = new User();

        //EventDto eventDto = new EventDto("2021-01-16", "2021-01-26", "테스트 전시", 3, 0, "09", "18", "09", "18", "서울", "세종미술관", "일요일", "세부내용", "");
        EventDto eventDto = new EventDto(Date.valueOf("2021-01-16"), Date.valueOf("2021-01-26"), "테스트 전시", 3, 0, Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "세종미술관", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0);

        Display display = Display.createDisplay(eventDto);
        displayRepository.saveDisplay(display);

        //em.persist(display); //등록 함수 만들기
        //orderItem 도메인 잘봐봐
        FavoriteDisplayId favoriteDisplayId = FavoriteDisplayId.createFavoriteDisplayId(user.getUserId(), display.getDisplayId());

        System.out.println("user = " + user.getUserId());
        System.out.println("display = " + display.getDisplayId());

        //when
        favoriteRepository.saveFavoriteDisplay(favoriteDisplayId);

        //then
        Assertions.assertEquals(display, displayRepository.findOne(display.getDisplayId()));
    }



}
