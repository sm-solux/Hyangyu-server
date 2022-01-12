package hyangyu.server.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class FavoriteDisplay {

    @EmbeddedId
    private FavoriteDisplayId favoriteDisplayId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("displayId")
    @JoinColumn(name = "display_id")
    private Display display;

}
