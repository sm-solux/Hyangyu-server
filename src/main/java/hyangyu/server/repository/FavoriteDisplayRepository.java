package hyangyu.server.repository;

import hyangyu.server.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FavoriteRepository {

    private final EntityManager em;

    public void saveFavoriteDisplay(FavoriteDisplayId favoriteDisplayId) {
        em.persist(favoriteDisplayId);
    }

    /*
    public saveFair(User user, Fair fair) {

    }

    public saveFestival(User user, Festival festival) {

    }

     */


}
