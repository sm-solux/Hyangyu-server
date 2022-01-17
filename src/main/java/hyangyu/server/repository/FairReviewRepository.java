package hyangyu.server.repository;

import hyangyu.server.domain.FairReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FairReviewRepository extends JpaRepository<FairReview, Long> {
}
