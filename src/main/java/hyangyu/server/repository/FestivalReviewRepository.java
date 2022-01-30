package hyangyu.server.repository;

import hyangyu.server.domain.FestivalReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FestivalReviewRepository extends JpaRepository<FestivalReview, Long> {

    @Query("select count(r) from FestivalReview r where r.festival.festivalId=?1 and r.user.userId=?2")
    public int getCount(Long festivalId, Long userId);

    @Query("select r from FestivalReview r where r.festival.festivalId=?1 and r.user.userId=?2")
    public FestivalReview getFestivalReview(Long festivalId, Long userId);
}
