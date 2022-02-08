package hyangyu.server.repository;

import hyangyu.server.domain.DisplayReview;
import hyangyu.server.dto.ReviewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisplayReviewRepository extends JpaRepository<DisplayReview, Long> {

    @Query("select count(r) from DisplayReview r where r.display.displayId=?1 and r.user.userId=?2")
    public int getCount(Long displayId, Long userId);

    @Query("select r from DisplayReview r where r.display.displayId=?1 and r.user.userId=?2")
    public DisplayReview getDisplayReview(Long displayId, Long userId);

    @Query("select new hyangyu.server.dto.ReviewDto(r.user.image ,r.nickname, r.createTime, r.content, r.score) from DisplayReview r where r.display.displayId=?1")
    public List<ReviewDto> getDisplayReviews(Long displayId);
}
