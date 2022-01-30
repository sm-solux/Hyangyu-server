package hyangyu.server.api;

import hyangyu.server.domain.*;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.RequestReviewDto;
import hyangyu.server.dto.SaveReviewResponseDto;
import hyangyu.server.service.*;
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
    private final FairReviewService fairReviewService;
    private final FestivalReviewService festivalReviewService;
    private final DisplayService displayService;
    private final FairService fairService;
    private final FestivalService festivalService;
    private final UserService userService;

    @PostMapping("/review/display/{displayId}")
    public ResponseEntity saveDisplayReview(@PathVariable Long displayId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Display> display = displayService.findOne(displayId);
        if (display.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 전시 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 저장
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }

        int count = displayReviewService.saveDisplayReview(userId, displayId, requestReviewDto);
        if (count == 0) {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 작성이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity(new ErrorDto(404, "이미 전시에 대한 리뷰를 달았습니다."), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/review/fair/{fairId}")
    public ResponseEntity saveFairReview(@PathVariable Long fairId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //박람회 검색
        Optional<Fair> fair = fairService.findOne(fairId);
        if (fair.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 박람회 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 저장
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }

        int count = fairReviewService.saveFairReview(userId, fairId, requestReviewDto);
        if (count == 0) {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 작성이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity(new ErrorDto(404, "이미 박람회에 대한 리뷰를 달았습니다."), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/review/festival/{festivalId}")
    public ResponseEntity saveFestivalReview(@PathVariable Long festivalId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //페스티벌 검색
        Optional<Festival> festival = festivalService.findOne(festivalId);
        if (festival.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 페스티벌 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 저장
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }

        int count = festivalReviewService.saveFestivalReview(userId, festivalId, requestReviewDto);
        if (count == 0) {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 작성이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity(new ErrorDto(404, "이미 페스티벌에 대한 리뷰를 달았습니다."), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/review/change/display/{displayId}")
    public ResponseEntity updateDisplayReview(@PathVariable Long displayId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Display> display = displayService.findOne(displayId);
        if (display.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 전시 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 길이 제한
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }
        Optional<DisplayReview> displayReview = displayReviewService.modifyDisplayReview(userId, displayId, requestReviewDto);
        if (displayReview.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "수정할 리뷰가 없습니다."), HttpStatus.BAD_REQUEST);
        } else {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 수정이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        }
    }

    @PostMapping("/review/change/fair/{fairId}")
    public ResponseEntity updateFairReview(@PathVariable Long fairId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //박람회 검색
        Optional<Fair> fair = fairService.findOne(fairId);
        if (fair.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 박람회 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 길이 제한
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }
        Optional<FairReview> fairReview = fairReviewService.modifyFairReview(userId, fairId, requestReviewDto);
        if (fairReview.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "수정할 리뷰가 없습니다."), HttpStatus.BAD_REQUEST);
        } else {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 수정이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        }
    }

    @PostMapping("/review/change/festival/{festivalId}")
    public ResponseEntity updateFestivalReview(@PathVariable Long festivalId, @RequestBody RequestReviewDto requestReviewDto) throws Exception {
        // jwt 해독 코드 추후 추가
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //페스티벌 검색
        Optional<Festival> festival = festivalService.findOne(festivalId);
        if (festival.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 페스티벌 번호입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if (user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //리뷰 길이 제한
        int length = requestReviewDto.getContent().length();
        if (length > 300) {
            return new ResponseEntity(new ErrorDto(404, "리뷰 길이가 300자를 초과합니다."), HttpStatus.BAD_REQUEST);
        }
        Optional<FestivalReview> festivalReview = festivalReviewService.modifyFestivalReview(userId, festivalId, requestReviewDto);
        if (festivalReview.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "수정할 리뷰가 없습니다."), HttpStatus.BAD_REQUEST);
        } else {
            SaveReviewResponseDto saveReviewResponseDto = new SaveReviewResponseDto(200, "리뷰 수정이 완료되었습니다.");
            return new ResponseEntity(saveReviewResponseDto, httpHeaders, HttpStatus.OK);
        }
    }
}
