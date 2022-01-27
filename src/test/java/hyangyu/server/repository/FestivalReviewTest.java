package hyangyu.server.repository;

import hyangyu.server.domain.*;
import hyangyu.server.dto.EventDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class FestivalReviewTest {

    @Autowired
    FestivalReviewRepository festivalReviewRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("페스티벌 리뷰 저장")
    void saveFestivalReview() throws Exception {
        //given
        User user = User.createUser("test@naver.com", "test1234", "향유", "sub", "token", "image");
        em.persist(user);

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-17"), Date.valueOf("2021-01-20"), "박람회제목", 2, 0, Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), "위치", "사이트주소", "매주 월요일", "내용", "사진1", "사진2", "사진3", 20000);
        Festival festival = Festival.createFestival(eventDto);
        em.persist(festival);

        //when
        FestivalReview festivalReview = FestivalReview.createFestivalReview(user, festival, user.getUsername(), LocalDateTime.now(), "내용", 5);
        FestivalReview savedFestivalReview = festivalReviewRepository.save(festivalReview);
        int count = festivalReviewRepository.getCount(festival.getFestivalId(), user.getUserId());

        //then
        assertEquals(festivalReview, savedFestivalReview);
        assertEquals(festivalReview.getReviewId(), savedFestivalReview.getReviewId());
        assertThat(count).isEqualTo(1);
    }
}
