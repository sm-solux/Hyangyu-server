package hyangyu.server.saveFavoriteEvent;

import hyangyu.server.domain.Display;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DisplayRepository {

    private final EntityManager em;

    public void saveDisplay(Display display) {
        em.persist(display);
    }

    public Optional<Display> findOne(Long displayId) {
        return Optional.ofNullable(em.find(Display.class, displayId));
    }
}
