package hyangyu.server.api;

import hyangyu.server.domain.Display;
import hyangyu.server.domain.FavoriteDisplay;
import hyangyu.server.domain.User;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.SaveFavoriteResponseDto;
import hyangyu.server.service.DisplayService;
import hyangyu.server.service.FavoriteDisplayService;
import hyangyu.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FavoriteApi {
    private final DisplayService displayService;
    private final FavoriteDisplayService favoriteDisplayService;
    private final UserService userService;

    @PostMapping("/display/{displayId}")
    public ResponseEntity saveDisplay(@PathVariable Long displayId) throws Exception {
        //jwt 해독하는 코드 나오면 추후 수정
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

        //저장한 전시회 검색
        Optional<FavoriteDisplay> favoriteDisplay = favoriteDisplayService.saveFavoriteDisplay(userId, displayId);
        if(favoriteDisplay.isPresent()) {
            return new ResponseEntity(new ErrorDto(400, "이미 저장한 전시회입니다."), HttpStatus.BAD_REQUEST);
        }

        SaveFavoriteResponseDto saveFavoriteResponseDto = new SaveFavoriteResponseDto(200, "내가 저장한 전시회에 추가되었습니다.");
        return new ResponseEntity<>(saveFavoriteResponseDto, httpHeaders, HttpStatus.OK);
    }
}
