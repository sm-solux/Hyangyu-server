package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FavoriteFestivalId implements Serializable {
    private Long userId;
    private Long festivalId;

    public FavoriteFestivalId(Long userId, Long festivalId) {
        this.userId = userId;
        this.festivalId = festivalId;
    }
}
