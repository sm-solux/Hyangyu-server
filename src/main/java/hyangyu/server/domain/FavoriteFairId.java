package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteFairId implements Serializable {
    private Long userId;
    private Long fairId;

    public FavoriteFairId(Long userId, Long fairId) {
        this.userId = userId;
        this.fairId = fairId;
    }
}
