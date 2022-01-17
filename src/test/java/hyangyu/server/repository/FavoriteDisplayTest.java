package hyangyu.server.repository;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.FavoriteDisplay;
import hyangyu.server.domain.FavoriteDisplayId;
import hyangyu.server.domain.User;
import hyangyu.server.dto.EventDto;
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
public class FavoriteDisplayTest {

    @Autowired
    FavoriteDisplayRepository favoriteDisplayRepository;
    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    EntityManager em;

    @Test
    void saveDisplay() {

        //given
        User user = User.createUser("hyangyu@naver.com", "abcd1234", "향유");
        em.persist(user);

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-16"), Date.valueOf("2021-01-26"), "테스트 전시", 3, 0, Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "세종미술관", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0);

        Display display = Display.createDisplay(eventDto);
        displayRepository.saveDisplay(display);

        System.out.println("user = " + user.getUserId());
        System.out.println("display = " + display.getDisplayId());

        FavoriteDisplayId favoriteDisplayId = FavoriteDisplayId.createFavoriteDisplayId(user.getUserId(), display.getDisplayId());
        FavoriteDisplay favoriteDisplay = FavoriteDisplay.saveDisplayId(favoriteDisplayId);


        System.out.println(favoriteDisplay.getUser().getUsername());
        //System.out.println(favoriteDisplay.getFavoriteDisplayId());

        //when
        favoriteDisplayRepository.saveFavoriteDisplay(favoriteDisplay);

        //then
        Assertions.assertEquals(display, displayRepository.findOne(display.getDisplayId()));
    }



}
