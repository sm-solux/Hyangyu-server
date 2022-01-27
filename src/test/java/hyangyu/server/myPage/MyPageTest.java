package hyangyu.server.myPage;

import hyangyu.server.saveFavoriteEvent.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class MyPageTest {

    @Autowired
    DisplayRepository displayRepository;
    @Autowired
    FairRepository fairRepository;
    @Autowired
    FestivalRepository festivalRepository;

    @Autowired
    FavoriteDisplayRepository favoriteDisplayRepository;
    @Autowired
    FavoriteFairRepository favoriteFairRepository;
    @Autowired
    FavoriteFestivalRepository favoriteFestivalRepository;

    @Autowired
    EntityManager em;

    @Test
    void MyPage() {

    }
}
