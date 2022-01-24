package hyangyu.server.repository;

import hyangyu.server.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FavoriteDisplayRepository {

    private final EntityManager em;

    public void saveFavoriteDisplay(FavoriteDisplay favoriteDisplay) {
        em.persist(favoriteDisplay);
    }

    public FavoriteDisplay findOne(FavoriteDisplayId favoriteDisplayId) {
        return em.find(FavoriteDisplay.class, favoriteDisplayId);
    }

}
