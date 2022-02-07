package hyangyu.server.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hyangyu.server.domain.Display;
import hyangyu.server.domain.QDisplay;
import hyangyu.server.domain.QFair;
import hyangyu.server.domain.QFestival;
import hyangyu.server.dto.event.DisplayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DisplayRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    QDisplay display = QDisplay.display;

    public void saveDisplay(Display display) {
        em.persist(display);
    }

    public Optional<Display> findOne(Long displayId) {
        return Optional.ofNullable(em.find(Display.class, displayId));
    }

    public DisplayDto getDisplay(Long userId, String order, int page) {
        if (order.equals("latest")) {

        }

        else if (order.equals("popularity")) {

        }

        else if (order.equals("charge")) {

        }

        else if (order.equals("free")) {

        }

        else {
            //예외처리 해주세요~
        }

        List<Display> displays = queryFactory.select(display)
                .from(display)
                .orderBy(display.startDate.desc())
                .offset(page*10)
                .limit(10)
                .fetch();
    }
}
