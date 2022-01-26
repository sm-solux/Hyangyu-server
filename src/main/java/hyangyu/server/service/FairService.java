package hyangyu.server.service;

import hyangyu.server.domain.Fair;
import hyangyu.server.saveFavoriteEvent.FairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FairService {
    private final FairRepository fairRepository;

    @Transactional(readOnly = false)
    public void saveFair(Fair fair) {
        fairRepository.saveFair(fair);
    }

    public Optional<Fair> findOne(Long fairId) throws Exception {
        Optional<Fair> result = fairRepository.findOne(fairId);
        return result;
    }

}
