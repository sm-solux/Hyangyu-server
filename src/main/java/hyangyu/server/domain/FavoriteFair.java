package hyangyu.server.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class FavoriteDisplay {

    @EmbeddedId
    private FavoriteDisplayId favoriteId;

    @Enumerated
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("displayId")
    private Display display;

}
