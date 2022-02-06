package hyangyu.server.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BlockedUserId implements Serializable {
    private Long userId;
    private Long reportedId;

    public BlockedUserId(Long userId, Long reportedId) {
        this.userId = userId;
        this.reportedId = reportedId;
    }
}
