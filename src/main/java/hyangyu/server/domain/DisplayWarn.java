package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisplayWarn {

    @Id
    @GeneratedValue
    private Long warnId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    @NotNull
    private DisplayReview displayReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public static DisplayWarn createDisplayWarn(DisplayReview displayReview, User user) {
        DisplayWarn displayWarn = new DisplayWarn();
        displayWarn.displayReview = displayReview;
        displayWarn.user = user;
        return displayWarn;
    }
}
