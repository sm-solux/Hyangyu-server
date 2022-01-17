package hyangyu.server.repository;

import hyangyu.server.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class FavoriteDisplayRepository {

    private final EntityManager em;

    public void saveFavoriteDisplay(FavoriteDisplay favoriteDisplay) {
        em.persist(favoriteDisplay);
    }

    /*
    public saveFair(User user, Fair fair) {

    }

    public saveFestival(User user, Festival festival) {

    }

     */


}
