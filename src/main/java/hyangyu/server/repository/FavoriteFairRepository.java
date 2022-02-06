package hyangyu.server.repository;

import hyangyu.server.domain.FavoriteFair;
import hyangyu.server.domain.FavoriteFairId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FavoriteFairRepository {

    private final EntityManager em;

    public void saveFavoriteFair(FavoriteFair favoriteFair) {
        em.persist(favoriteFair);
    }

    public FavoriteFair findOne(FavoriteFairId favoriteFairId) {
        return em.find(FavoriteFair.class, favoriteFairId);
    }

    public void deleteFavoriteFair(FavoriteFair favoriteFair) { em.remove(em.find(FavoriteFair.class, favoriteFair.getFavoriteFairId()));}
}
