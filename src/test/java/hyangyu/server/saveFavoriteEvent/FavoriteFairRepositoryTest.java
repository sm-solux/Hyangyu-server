package hyangyu.server.saveFavoriteEvent;

import hyangyu.server.domain.*;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.ReviewDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class FavoriteFairRepositoryTest {
    @Autowired
    FavoriteFairRepository favoriteFairRepository;
    @Autowired
    FairRepository fairRepository;
    @Autowired
    EntityManager em;

    @Test
    void saveFair() {

        //given

        //사용자 생성
        User user = User.createUser("hyangyu@google.com", "abcd1234", "향유향유", null, "token", null);
        em.persist(user);

        //박람회 생성
        List<ReviewDto> reviews = new ArrayList<>();
        EventDto eventDto = new EventDto("전시 제목", Date.valueOf("2021-01-16"), Date.valueOf("2021-01-26"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "세종미술관", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0, true, reviews);
        Fair fair = Fair.createFair(eventDto);
        fairRepository.saveFair(fair);

        //내가 저장한 박람회 생성
        FavoriteFair favoriteFair = new FavoriteFair(user, fair);

        //when
        favoriteFairRepository.saveFavoriteFair(favoriteFair);

        //then
        Assertions.assertEquals(fair, fairRepository.findOne(fair.getFairId()).get());
        Assertions.assertEquals(fair, favoriteFairRepository.findOne(favoriteFair.getFavoriteFairId()).getFair());
    }
}
