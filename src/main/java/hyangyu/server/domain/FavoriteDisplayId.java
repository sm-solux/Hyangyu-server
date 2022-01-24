package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteDisplayId implements Serializable {
    private Long userId;
    private Long displayId;

    public FavoriteDisplayId(Long userId, Long displayId) {
        this.userId = userId;
        this.displayId = displayId;
    }
}



