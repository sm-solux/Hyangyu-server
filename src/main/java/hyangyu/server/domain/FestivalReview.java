package hyangyu.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FestivalReview {

    @Id
    @GeneratedValue
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    @NotNull
    private Festival festival;

    @NotNull
    @Column(length = 20)
    private String nickname;

    @NotNull
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "Asia/Seoul")
    private LocalDateTime createTime;

    @NotNull
    @Column(length = 300)
    private String content;

    @NotNull
    private Integer score;

    // 생성 메서드
    public static FestivalReview createFestivalReview(User user, Festival festival, String nickname, LocalDateTime createTime, String content, Integer score) {
        FestivalReview festivalReview = new FestivalReview();
        festivalReview.user = user;
        festivalReview.festival = festival;
        festivalReview.nickname = nickname;
        festivalReview.createTime = createTime;
        festivalReview.content = content;
        festivalReview.score = score;
        return festivalReview;
    }
}
