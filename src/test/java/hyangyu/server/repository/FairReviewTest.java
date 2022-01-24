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
class FairReviewTest {

    @Autowired
    FairReviewRepository fairReviewRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("박람회 리뷰 저장")
    void saveFairReview() throws Exception {
        //given
        User user = User.createUser("test@naver.com", "test1234", "향유", "sub", "token", "image");
        em.persist(user);

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-17"), Date.valueOf("2021-01-20"), "박람회제목", 2, 0, Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), "위치", "사이트주소", Date.valueOf("2021-01-01"), "내용", "사진1", "사진2", "사진3", 20000);
        Fair fair = Fair.createFair(eventDto);
        em.persist(fair);

        //when
        FairReview fairReview = FairReview.createFairReview(user, fair, user.getUsername(), LocalDateTime.now(), "내용", 5);
        FairReview savedFairReview = fairReviewRepository.save(fairReview);
        int count = fairReviewRepository.findReview(fair.getFairId(), user.getUserId());

        //then
        assertEquals(fairReview, savedFairReview);
        assertEquals(fairReview.getReviewId(), savedFairReview.getReviewId());
        assertThat(count).isEqualTo(1);
    }
}
