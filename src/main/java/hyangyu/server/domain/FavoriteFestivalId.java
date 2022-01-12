package hyangyu.server.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavoriteFestivalId implements Serializable {

    private Long userId;
    private Long festivalId;
}
