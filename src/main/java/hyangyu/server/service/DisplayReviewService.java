package hyangyu.server.service;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.DisplayReview;
import hyangyu.server.domain.User;
import hyangyu.server.dto.RequestReviewDto;
import hyangyu.server.repository.DisplayRepository;
import hyangyu.server.repository.DisplayReviewRepository;
import hyangyu.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DisplayReviewService {

    private final DisplayReviewRepository displayReviewRepository;
    private final UserRepository userRepository;
    private final DisplayRepository displayRepository;

    @Transactional(readOnly = false)
    public Long saveDisplayReview(Long userId, Long displayId, RequestReviewDto requestReviewDto) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Display> display = displayRepository.findOne(displayId);
        int count = displayReviewRepository.getCount(display.get().getDisplayId(), user.get().getUserId());
        if (count == 0) {
            DisplayReview displayReview = DisplayReview.createDisplayReview(user.get(), display.get(), user.get().getUsername(), LocalDateTime.now(), requestReviewDto.getContent(), requestReviewDto.getScore(), 0);
            DisplayReview savedDisplayReview = displayReviewRepository.save(displayReview);
            return savedDisplayReview.getReviewId();
        } else {
            return -1L;
        }
    }

    @Transactional(readOnly = false)
    public Optional<DisplayReview> modifyDisplayReview(Long userId, Long displayId, RequestReviewDto requestReviewDto) {
        Optional<DisplayReview> displayReview = Optional.ofNullable(displayReviewRepository.getDisplayReview(displayId, userId));
        displayReview.ifPresent(review -> review.updateDisplayReview(requestReviewDto.getContent(), requestReviewDto.getScore()));
        return displayReview;
    }

    @Transactional
    public Optional<DisplayReview> deleteDisplayReview(Long userId, Long displayId) {
        Optional<DisplayReview> displayReview = Optional.ofNullable(displayReviewRepository.getDisplayReview(displayId, userId));
        displayReview.ifPresent(displayReviewRepository::delete);
        return displayReview;
    }
}
