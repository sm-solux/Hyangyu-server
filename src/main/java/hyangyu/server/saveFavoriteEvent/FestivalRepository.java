package hyangyu.server.saveFavoriteEvent;

import hyangyu.server.domain.Festival;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FestivalRepository {

    private final EntityManager em;

    public void saveFestival(Festival festival) {
        em.persist(festival);
    }

    public Optional<Festival> findOne(Long festivalId) {
        return Optional.ofNullable(em.find(Festival.class, festivalId));
    }
}
