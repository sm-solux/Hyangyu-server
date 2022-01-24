package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteFair {

    @EmbeddedId
    private FavoriteFairId favoriteFairId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("fairId")
    @JoinColumn(name = "fair_id")
    private Fair fair;

    //생성자
    public FavoriteFair(User user, Fair fair) {
        FavoriteFairId favoriteFairId = new FavoriteFairId(user.getUserId(), fair.getFairId());
        this.favoriteFairId = favoriteFairId;
        this.user = user;
        this.fair = fair;
    }

}
