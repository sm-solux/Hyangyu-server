package hyangyu.server.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteDisplayId implements Serializable {
    private Long userId;
    private Long displayId;
}
