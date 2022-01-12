package hyangyu.server.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Favorite {

    //@Id 애노테이션 빼고 복합키 설정, 단방향 맵핑 @ManyToOne(mappedBy 필요없음, 연관관계는 무조건 객체에다 하면됨)
    @EmbeddedId
    private FavoriteDisplayId favoriteId;

    @Enumerated
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventId")
    private Display display;

}
