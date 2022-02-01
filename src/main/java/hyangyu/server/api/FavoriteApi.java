package hyangyu.server.api;

import hyangyu.server.domain.*;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.ResponseDto;
import hyangyu.server.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FavoriteApi {
    private final DisplayService displayService;
    private final FavoriteDisplayService favoriteDisplayService;

    private final FairService fairService;
    private final FavoriteFairService favoriteFairService;

    private final FestivalService festivalService;
    private final FavoriteFestivalService favoriteFestivalService;
    private final UserService userService;

    @PostMapping("/display/{displayId}")
    public ResponseEntity saveFavoriteDisplay(@PathVariable Long displayId) throws Exception {
        //jwt 해독하는 코드 나오면 추후 수정
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Display> display = displayService.findOne(displayId);
        if(display.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 전시 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteDisplay> favoriteDisplay = favoriteDisplayService.saveFavoriteDisplay(userId, displayId);
        if(favoriteDisplay.isPresent()) {
            return new ResponseEntity(new ErrorDto(404, "이미 저장한 전시회입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 전시회에 추가되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/fair/{fairId}")
    public ResponseEntity saveFavoriteFair(@PathVariable Long fairId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //박람회 검색
        Optional<Fair> fair = fairService.findOne(fairId);
        if(fair.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 박람회 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteFair> favoriteFair = favoriteFairService.saveFavoriteFair(userId, fairId);
        if(favoriteFair.isPresent()) {
            return new ResponseEntity(new ErrorDto(404, "이미 저장한 박람회입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 박람회에 추가되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/festival/{festivalId}")
    public ResponseEntity saveFavoriteFestival(@PathVariable Long festivalId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //박람회 검색
        Optional<Festival> festival = festivalService.findOne(festivalId);
        if(festival.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 페스티벌 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteFestival> favoriteFestival = favoriteFestivalService.saveFavoriteFestival(userId, festivalId);
        if(favoriteFestival.isPresent()) {
            return new ResponseEntity(new ErrorDto(404, "이미 저장한 페스티벌입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 페스티벌에 추가되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/display/{displayId}")
    public ResponseEntity deleteFavoriteDisplay(@PathVariable Long displayId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Display> display = displayService.findOne(displayId);
        if(display.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 전시 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteDisplay> favoriteDisplay = favoriteDisplayService.deleteFavoriteDisplay(userId, displayId);
        if(favoriteDisplay.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "저장하지 않은 전시회입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 전시회에서 삭제되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/fair/{fairId}")
    public ResponseEntity deleteFavoriteFair(@PathVariable Long fairId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Fair> fair = fairService.findOne(fairId);
        if(fair.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 박람회 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteFair> favoriteFair = favoriteFairService.deleteFavoriteFair(userId, fairId);
        if(favoriteFair.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "저장하지 않은 박람회입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 박람회에서 삭제되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/festival/{festivalId}")
    public ResponseEntity deleteFavoriteFestival(@PathVariable Long festivalId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        //전시 검색
        Optional<Festival> festival = festivalService.findOne(festivalId);
        if(festival.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "잘못된 페스티벌 id입니다."), HttpStatus.BAD_REQUEST);
        }

        //사용자 검색
        Optional<User> user = userService.findUser(userId);
        if(user.isEmpty()) {
            return new ResponseEntity(new ErrorDto(401, "유효하지 않은 사용자입니다."), HttpStatus.BAD_REQUEST);
        }

        //저장한 전시회 검색
        Optional<FavoriteFestival> favoriteFestival = favoriteFestivalService.deleteFavoriteFestival(userId, festivalId);
        if(favoriteFestival.isEmpty()) {
            return new ResponseEntity(new ErrorDto(404, "저장하지 않은 페스티벌입니다."), HttpStatus.BAD_REQUEST);
        }

        ResponseDto responseDto = new ResponseDto(200, "내가 저장한 페스티벌에서 삭제되었습니다.");
        return new ResponseEntity<>(responseDto, httpHeaders, HttpStatus.OK);
    }

}
