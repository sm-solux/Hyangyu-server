package hyangyu.server.service;

import hyangyu.server.domain.Festival;
import hyangyu.server.saveFavoriteEvent.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FestivalService {
    private final FestivalRepository festivalRepository;

    @Transactional(readOnly = false)
    public void saveFestival(Festival festival) {
        festivalRepository.saveFestival(festival);
    }

    public Optional<Festival> findOne(Long festivalId) throws Exception {
        Optional<Festival> result = festivalRepository.findOne(festivalId);
        return result;
    }
}
