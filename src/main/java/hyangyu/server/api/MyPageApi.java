package hyangyu.server.api;

import hyangyu.server.domain.User;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.myPage.MyPageDto;
import hyangyu.server.dto.myPage.MyPageResponseDto;
import hyangyu.server.service.MyPageService;
import hyangyu.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyPageApi {

    private final UserService userService;
    private final MyPageService myPageService;

    @GetMapping("/myPage")
    public ResponseEntity getMyPage() throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        MyPageDto myPageDto = myPageService.getMyPage();
        MyPageResponseDto myPageResponseDto = new MyPageResponseDto(200, myPageDto);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }
}
