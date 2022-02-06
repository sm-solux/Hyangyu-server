package hyangyu.server.service;

import hyangyu.server.dto.myPage.MyPageDto;
import hyangyu.server.repository.MyPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageService {

    private final MyPageRepository myPageRepository;

    public MyPageDto getMyPage(Long userId) {
        MyPageDto myPageDto = myPageRepository.getMyPage(userId);
        return myPageDto;
    }
}
