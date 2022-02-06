package hyangyu.server.api;

import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.UserDto;
import hyangyu.server.dto.myPage.*;
import hyangyu.server.service.MyPageService;
import hyangyu.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyPageApi {

    private final UserService userService;
    private final MyPageService myPageService;

    @GetMapping("/myPage")
    public ResponseEntity getMyPage() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        UserDto user = userService.getMyUserWithAuthorities();
        if(user == null) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        MyPageDto myPageDto = myPageService.getMyPage(user.getUserId());
        myPageDto.setImage(user.getImage());
        myPageDto.setUsername(user.getUsername());
        MyPageResponseDto myPageResponseDto = new MyPageResponseDto(200, myPageDto);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/display/{page}")
    public ResponseEntity getMyDisplay(@PathVariable int page) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        UserDto user = userService.getMyUserWithAuthorities();
        if(user == null) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        MyDisplayDto myDisplay = myPageService.getMyDisplay(user.getUserId(), page);
        MyDisplayResponseDto myPageResponseDto = new MyDisplayResponseDto(200, myDisplay);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/fair/{page}")
    public ResponseEntity getMyFair(@PathVariable int page) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        UserDto user = userService.getMyUserWithAuthorities();
        if(user == null) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        MyFairDto myFair = myPageService.getMyFair(user.getUserId(), page);
        MyFairResponseDto myPageResponseDto = new MyFairResponseDto(200, myFair);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/festival/{page}")
    public ResponseEntity getMyFestival(@PathVariable int page) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        UserDto user = userService.getMyUserWithAuthorities();
        if(user == null) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        MyFestivalDto myFestival = myPageService.getMyFestival(user.getUserId(), page);
        MyFestivalResponseDto myPageResponseDto = new MyFestivalResponseDto(200, myFestival);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }
}
