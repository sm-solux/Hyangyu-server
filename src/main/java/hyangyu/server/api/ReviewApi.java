package hyangyu.server.api;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.User;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.RequestReviewDto;
import hyangyu.server.dto.SaveReviewResponseDto;
import hyangyu.server.service.DisplayReviewService;
import hyangyu.server.service.DisplayService;
import hyangyu.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewApi {

    private final DisplayReviewService displayReviewService;
    private final DisplayService displayService;
    private final UserService userService;

    @PostMapping("/review/display/{displayId}")
    public ResponseEntity saveDisplayReview(@PathVariable Long displayId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Display> display = displayService.findOne(displayId);
        if(display.isEmpty()) {
            return new ResponseEntity(new ErrorDto(400, "잘못된 전시 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(400, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 저장
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(400, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }

        int count = displayReviewService.saveDisplayReview(userId, displayId, requestReviewDto);
        if (count == 0) {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 작성이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity(new ErrorDto(400, "이미 전시에 대한 리뷰를 달았습니다."), HttpStatus.BAD_REQUEST);
        }
    }
}
