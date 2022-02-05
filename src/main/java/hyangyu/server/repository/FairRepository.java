package hyangyu.server.saveFavoriteEvent;

import hyangyu.server.domain.Fair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FairRepository {
    private final EntityManager em;

    public void saveFair(Fair fair) {
        em.persist(fair);
    }

    public Optional<Fair> findOne(Long fairId) {
        return Optional.ofNullable(em.find(Fair.class, fairId));
    }
}
