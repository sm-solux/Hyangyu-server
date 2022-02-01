package hyangyu.server.service;

import hyangyu.server.domain.Festival;
import hyangyu.server.domain.FestivalReview;
import hyangyu.server.domain.User;
import hyangyu.server.dto.RequestReviewDto;
import hyangyu.server.repository.FestivalRepository;
import hyangyu.server.repository.FestivalReviewRepository;
import hyangyu.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FestivalReviewService {

    private final FestivalReviewRepository festivalReviewRepository;
    private final UserRepository userRepository;
    private final FestivalRepository festivalRepository;

    @Transactional(readOnly = false)
    public int saveFestivalReview(Long userId, Long festivalId, RequestReviewDto requestReviewDto) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Festival> festival = festivalRepository.findOne(festivalId);
        int count = festivalReviewRepository.getCount(festival.get().getFestivalId(), user.get().getUserId());
        if (count == 0) {
            FestivalReview festivalReview = FestivalReview.createFestivalReview(user.get(), festival.get(), user.get().getUsername(), LocalDateTime.now(), requestReviewDto.getContent(), requestReviewDto.getScore());
            festivalReviewRepository.save(festivalReview);
        }
        return count;
    }

    @Transactional(readOnly = false)
    public Optional<FestivalReview> modifyFestivalReview(Long userId, Long festivalId, RequestReviewDto requestReviewDto) {
        Optional<FestivalReview> festivalReview = Optional.ofNullable(festivalReviewRepository.getFestivalReview(festivalId, userId));
        festivalReview.ifPresent(review -> review.updateFestivalReview(requestReviewDto.getContent(), requestReviewDto.getScore()));
        return festivalReview;
    }

    @Transactional
    public Optional<FestivalReview> deleteFestivalReview(Long userId, Long festivalId) {
        Optional<FestivalReview> festivalReview = Optional.ofNullable(festivalReviewRepository.getFestivalReview(festivalId, userId));
        festivalReview.ifPresent(festivalReviewRepository::delete);
        return festivalReview;
    }
}
