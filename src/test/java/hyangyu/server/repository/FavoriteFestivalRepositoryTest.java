package hyangyu.server.saveFavoriteEvent;

import hyangyu.server.domain.Festival;
import hyangyu.server.domain.FavoriteFestival;
import hyangyu.server.domain.User;
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
public class FavoriteFestivalRepositoryTest {
    @Autowired
    FavoriteFestivalRepository favoriteFestivalRepository;
    @Autowired
    FestivalRepository festivalRepository;
    @Autowired
    EntityManager em;

    @Test
    void saveFestival() {

        //given

        //사용자 생성
        User user = User.createUser("hyangyu@google.com", "abcd1234", "향유향유", null, "token", null);
        em.persist(user);

        //박람회 생성
<<<<<<< HEAD:src/test/java/hyangyu/server/saveFavoriteEvent/FavoriteFestivalRepositoryTest.java
        List<ReviewDto> reviews = new ArrayList<>();
        EventDto eventDto = new EventDto("전시 제목", Date.valueOf("2021-01-16"), Date.valueOf("2021-01-26"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "세종미술관", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0, true, reviews);
=======
        EventDto eventDto = new EventDto(Date.valueOf("2021-01-24"), Date.valueOf("2021-01-28"), "테스트 전시2", 5, 0, Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "향유미술관", "매주 월요일", "세부내용", "", "", "", 0);
>>>>>>> 0a23a43610736643e745f4fc1e3876b6f656a826:src/test/java/hyangyu/server/repository/FavoriteFestivalRepositoryTest.java
        Festival festival = Festival.createFestival(eventDto);

        festivalRepository.saveFestival(festival);

        //내가 저장한 페스티벌 생성
        FavoriteFestival favoriteFestival = new FavoriteFestival(user, festival);

        //when
        favoriteFestivalRepository.saveFavoriteFestival(favoriteFestival);

        //then
        Assertions.assertEquals(festival, festivalRepository.findOne(festival.getFestivalId()).get());
        Assertions.assertEquals(festival, favoriteFestivalRepository.findOne(favoriteFestival.getFavoriteFestivalId()).getFestival());
    }
}
