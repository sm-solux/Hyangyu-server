package hyangyu.server.service;

import hyangyu.server.dto.myPage.MyDisplayDto;
import hyangyu.server.dto.myPage.MyFairDto;
import hyangyu.server.dto.myPage.MyFestivalDto;
import hyangyu.server.dto.myPage.MyPageDto;
import hyangyu.server.repository.MyPageRepository;
import lombok.RequiredArgsConstructor;
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

    public MyDisplayDto getMyDisplay(Long userId, int page) {
        MyDisplayDto myDisplayDto = myPageRepository.getMyDisplay(userId, page);
        return myDisplayDto;
    }

    public MyFairDto getMyFair(Long userId, int page) {
        MyFairDto myFairDto = myPageRepository.getMyFair(userId, page);
        return myFairDto;
    }

    public MyFestivalDto getMyFestival(Long userId, int page) {
        MyFestivalDto myFestivalDto = myPageRepository.getMyFestival(userId, page);
        return myFestivalDto;
    }
}
