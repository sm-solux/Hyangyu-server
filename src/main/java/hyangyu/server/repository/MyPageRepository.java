package hyangyu.server.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hyangyu.server.domain.*;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.myPage.MyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MyPageRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MyPageRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public MyPageDto getMyPage() {
        QUser user = QUser.user;
        QFavoriteDisplay favoriteDisplay = QFavoriteDisplay.favoriteDisplay;
        QDisplay display = QDisplay.display;

        Long id = 1L;
        /*
        List<Tuple> tuples = queryFactory.select(new MyPageDto(
                ))
                .from(favoriteDisplay)
                .join(display)
                .join(user)
                .where(favoriteDisplay.user.userId.castToNum(Long.class).eq(id))
                .fetch();

         */

        //SELECT user.username, user.image, display.*, favorite_display.* FROM Hyangyu.favorite_display JOIN user JOIN display where user_id=1;

        User user1 = queryFactory.select(user)
                .from(user)
                .where(user.userId.castToNum(Long.class).eq(id))
                .fetchOne();


        List<Display> displays = queryFactory.select(favoriteDisplay.display)
                .from(favoriteDisplay)
                .where(favoriteDisplay.user.userId.castToNum(Long.class).eq(id))
                .orderBy(favoriteDisplay.display.endDate.desc())
                //.where(favoriteDisplay.user.userId.castToNum(Long.class).eq(id))
                //어차피 favoriteDisplay 필요없는데 join 삭제하고 where절에만 쑤셔박으면 안되나..?
                .fetch();
        //이거다 ^^
        //limit(8) 추가하세욤~~ 자러감~~


        //join에서 where절을 사용하면 오류가 나는데 on절 사용하니까 됨... 이거뭐야?
        List<EventDto> displayList = new ArrayList<>();
        for (Display display1 : displays) {
            displayList.add(new EventDto(display1));
            //for each 문 말고 index 써서 isSaved 다 true 처리
        }

        MyPageDto myPageDto = new MyPageDto(user1.getImage(), user1.getUsername(), displayList);

        return myPageDto;

    }
}
