package hyangyu.server.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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
    public void saveDisplay(User user, Display display) {
        this.user = user;
        this.display = display;
    }

}
