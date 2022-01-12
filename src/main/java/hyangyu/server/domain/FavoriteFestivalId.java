package hyangyu.server.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteFairId implements Serializable {
    private Long userId;
    private Long displayId;
}
