package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteDisplay {

    @EmbeddedId
    private FavoriteDisplayId favoriteDisplayId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("displayId")
    @JoinColumn(name = "display_id")
    private Display display;

    //생성자
    public FavoriteDisplay(User user, Display display) {
        FavoriteDisplayId favoriteDisplayId = new FavoriteDisplayId(user.getUserId(), display.getDisplayId());
        this.favoriteDisplayId = favoriteDisplayId;
        this.user = user;
        this.display = display;
    }
}
