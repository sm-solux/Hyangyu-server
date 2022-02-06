package hyangyu.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlockedUser {

    @EmbeddedId
    private BlockedUserId blockedUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("reportedId")
    @JoinColumn(name = "reported_id")
    private User reportedUser;

    //생성자
    public BlockedUser(User user, User reportedUser) {
        BlockedUserId blockedUserId = new BlockedUserId(user.getUserId(), reportedUser.getUserId());
        this.blockedUserId = blockedUserId;
        this.user = user;
        this.reportedUser = reportedUser;
    }
}

