package hyangyu.server.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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

    //생성 메서드
    public void saveFair(User user, Fair fair) {
        this.user = user;
        this.fair = fair;
    }

}
