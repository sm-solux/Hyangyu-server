package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FairWarn {

    @Id
    @GeneratedValue
    private Long warnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @NotNull
    private FairReview fairReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public static FairWarn createFairWarn(FairReview fairReview, User user) {
        FairWarn fairWarn = new FairWarn();
        fairWarn.fairReview = fairReview;
        fairWarn.user = user;
        return fairWarn;
    }
}
