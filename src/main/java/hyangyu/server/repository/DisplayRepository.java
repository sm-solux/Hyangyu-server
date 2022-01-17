package hyangyu.server.repository;

import hyangyu.server.domain.Display;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DisplayRepository {

    private final EntityManager em;

    public void saveDisplay(Display display) { em.persist(display);}

    public Display findOne(Long displayId) {
        return em.find(Display.class, displayId);
    }
}
