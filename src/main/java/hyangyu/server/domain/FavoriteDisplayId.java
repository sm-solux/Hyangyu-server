package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteDisplayId implements Serializable {
    private Long userId;
    private Long displayId;

    public static FavoriteDisplayId createFavoriteDisplayId(Long userId, Long displayId) {
        FavoriteDisplayId favoriteDisplayId = new FavoriteDisplayId();
        favoriteDisplayId.userId = userId;
        favoriteDisplayId.displayId = displayId;
        return favoriteDisplayId;
    }
}


