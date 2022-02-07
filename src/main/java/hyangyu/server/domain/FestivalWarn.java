package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalWarn {

    @Id
    @GeneratedValue
    private Long warnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @NotNull
    private FestivalReview festivalReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public static FestivalWarn createFestivalWarn(FestivalReview festivalReview, User user) {
        FestivalWarn festivalWarn = new FestivalWarn();
        festivalWarn.festivalReview = festivalReview;
        festivalWarn.user = user;
        return festivalWarn;
    }
}
