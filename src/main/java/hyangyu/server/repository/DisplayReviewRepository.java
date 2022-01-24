package hyangyu.server.repository;

import hyangyu.server.domain.DisplayReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisplayReviewRepository extends JpaRepository<DisplayReview, Long> {

    @Query("select count(r) from DisplayReview r where r.display.displayId=?1 and r.user.userId=?2")
    public int getCount(Long diplayId, Long userId);
}
