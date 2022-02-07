package hyangyu.server.api;

import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.UserDto;
import hyangyu.server.dto.event.DisplayDto;
import hyangyu.server.dto.event.DisplayResponseDto;
import hyangyu.server.repository.DisplayRepository;
import hyangyu.server.repository.FairRepository;
import hyangyu.server.repository.FestivalRepository;
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
public class CategoryApi {

    private UserService userService;
    private DisplayRepository displayRepository;
    private FairRepository fairRepository;
    private FestivalRepository festivalRepository;

    @GetMapping("/display//{order}/{page}")
    public ResponseEntity getMyDisplay(@PathVariable String order, int page) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();

        //사용자 검색
        UserDto user = userService.getMyUserWithAuthorities();
        if(user == null) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        DisplayDto myDisplay = displayRepository.getDisplay(user.getUserId(), order, page);
        DisplayResponseDto myPageResponseDto = new DisplayResponseDto(200, myDisplay);
        return new ResponseEntity<>(myPageResponseDto, httpHeaders, HttpStatus.OK);
    }
}
