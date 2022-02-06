package hyangyu.server.service;

import hyangyu.server.domain.Fair;
import hyangyu.server.domain.FairReview;
import hyangyu.server.domain.User;
import hyangyu.server.dto.RequestReviewDto;
import hyangyu.server.repository.FairRepository;
import hyangyu.server.repository.FairReviewRepository;
import hyangyu.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FairReviewService {

    private final FairReviewRepository fairReviewRepository;
    private final UserRepository userRepository;
    private final FairRepository fairRepository;

    @Transactional(readOnly = false)
    public Long saveFairReview(Long userId, Long fairId, RequestReviewDto requestReviewDto) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Fair> fair = fairRepository.findOne(fairId);
        int count = fairReviewRepository.getCount(fair.get().getFairId(), user.get().getUserId());
        if (count == 0) {
            FairReview fairReview = FairReview.createFairReview(user.get(), fair.get(), user.get().getUsername(), LocalDateTime.now(), requestReviewDto.getContent(), requestReviewDto.getScore(), 0);
            FairReview savedFairReview = fairReviewRepository.save(fairReview);
            return savedFairReview.getReviewId();
        } else {
            return -1L;
        }
    }

    @Transactional(readOnly = false)
    public Optional<FairReview> modifyFairReview(Long userId, Long fairId, RequestReviewDto requestReviewDto) {
        Optional<FairReview> fairReview = Optional.ofNullable(fairReviewRepository.getFairReview(fairId, userId));
        fairReview.ifPresent(review -> review.updateFairReview(requestReviewDto.getContent(), requestReviewDto.getScore()));
        return fairReview;
    }

    @Transactional
    public Optional<FairReview> deleteFairReview(Long userId, Long fairId) {
        Optional<FairReview> fairReview = Optional.ofNullable(fairReviewRepository.getFairReview(fairId, userId));
        fairReview.ifPresent(fairReviewRepository::delete);
        return fairReview;
    }
}
