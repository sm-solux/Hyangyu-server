package hyangyu.server.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class FavoriteFair {

    @EmbeddedId
    private FavoriteFairId privateFairId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @MapsId("fairId")
    @JoinColumn(name = "fair_id")
    private Fair fair;



}
