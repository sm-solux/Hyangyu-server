package hyangyu.server.repository;

import hyangyu.server.domain.FestivalWarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FestivalWarnRepository extends JpaRepository<FestivalWarn, Long> {

    @Query("select w from FestivalWarn w where w.festivalReview.reviewId=?1 and w.user.userId=?2")
    public FestivalWarn getFestivalWarn(Long reviewId, Long userId);

    @Modifying
    @Transactional
    @Query("delete from FestivalWarn w where w.festivalReview.reviewId=?1")
    public void deleteFestivalWarns(Long reviewId);
}
