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

    //생성 메서드
    public static FavoriteDisplay saveDisplayId(FavoriteDisplayId favoriteDisplayId) {
        FavoriteDisplay favoriteDisplay = new FavoriteDisplay();
        favoriteDisplay.favoriteDisplayId = favoriteDisplayId;
        return favoriteDisplay;
    }

}
