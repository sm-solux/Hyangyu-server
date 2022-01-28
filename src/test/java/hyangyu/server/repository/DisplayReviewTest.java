package hyangyu.server.repository;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.DisplayReview;
import hyangyu.server.domain.User;
import hyangyu.server.dto.EventDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class DisplayReviewTest {

    @Autowired
    DisplayReviewRepository displayReviewRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("전시회 리뷰 저장")
    void saveDisplayReview() throws Exception {
        //given
        User user = User.createUser("test@naver.com", "test1234", "향유", "sub", "token", "image");
        em.persist(user);

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-17"), Date.valueOf("2021-01-20"), "전시제목", 2, 0, Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), "위치", "사이트주소", "매주 월요일", "내용", "사진1", "사진2", "사진3", 20000);
        Display display = Display.createDisplay(eventDto);
        em.persist(display);

        //when
        DisplayReview displayReview = DisplayReview.createDisplayReview(user, display, user.getUsername(), LocalDateTime.now(), "내용", 5);
        DisplayReview savedDisplayReview = displayReviewRepository.save(displayReview);
        int count = displayReviewRepository.getCount(display.getDisplayId(), user.getUserId());

        //then
        assertEquals(displayReview, savedDisplayReview);
        assertEquals(displayReview.getReviewId(), savedDisplayReview.getReviewId());
        assertThat(count).isEqualTo(1);
    }
}
