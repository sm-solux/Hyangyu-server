package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteFairId implements Serializable {
    private Long userId;
    private Long fairId;
}
