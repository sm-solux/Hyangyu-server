package hyangyu.server.repository;

import hyangyu.server.domain.FavoriteFestival;
import hyangyu.server.domain.FavoriteFestivalId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FavoriteFestivalRepository {
    private final EntityManager em;

    public void saveFavoriteFestival(FavoriteFestival favoriteFestival) {
        em.persist(favoriteFestival);
    }

    public FavoriteFestival findOne(FavoriteFestivalId favoriteFestivalId) {
        return em.find(FavoriteFestival.class, favoriteFestivalId);
    }
}
