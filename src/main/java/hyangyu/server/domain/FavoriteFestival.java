package hyangyu.server.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class FavoriteFair {

    @EmbeddedId
    private FavoriteFairId favoriteId;

    @Enumerated
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fairId")
    private Fair fair;

}
