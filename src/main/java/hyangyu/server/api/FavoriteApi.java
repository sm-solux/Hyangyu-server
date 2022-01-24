package hyangyu.server.api;

import hyangyu.server.domain.*;
import hyangyu.server.dto.ErrorDto;
import hyangyu.server.dto.EventDto;
import hyangyu.server.dto.SaveFavoriteResponseDto;
import hyangyu.server.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity saveDisplay(@PathVariable Long displayId) throws Exception {
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

        SaveFavoriteResponseDto saveFavoriteResponseDto = new SaveFavoriteResponseDto(200, "내가 저장한 전시회에 추가되었습니다.");
        return new ResponseEntity<>(saveFavoriteResponseDto, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/fair/{fairId}")
    public ResponseEntity saveFair(@PathVariable Long fairId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-24"), Date.valueOf("2021-01-28"), "테스트 박람회", 5, 0, Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "향유박람회", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0);
        Fair fair1 = Fair.createFair(eventDto);
        fairService.saveFair(fair1);

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

        SaveFavoriteResponseDto saveFavoriteResponseDto = new SaveFavoriteResponseDto(200, "내가 저장한 박람회에 추가되었습니다.");
        return new ResponseEntity<>(saveFavoriteResponseDto, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/festival/{festivalId}")
    public ResponseEntity saveFestival(@PathVariable Long festivalId) throws Exception {
        Long userId = 1L;
        HttpHeaders httpHeaders = new HttpHeaders();

        EventDto eventDto = new EventDto(Date.valueOf("2021-01-24"), Date.valueOf("2021-01-28"), "테스트 페스티벌", 5, 0, Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), Time.valueOf("09:00:00"), Time.valueOf("18:00:00"), "서울", "향유페스티벌", Date.valueOf("2021-01-26"), "세부내용", "", "", "", 0);
        Festival f = Festival.createFestival(eventDto);
        festivalService.saveFestival(f);

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

        SaveFavoriteResponseDto saveFavoriteResponseDto = new SaveFavoriteResponseDto(200, "내가 저장한 페스티벌에 추가되었습니다.");
        return new ResponseEntity<>(saveFavoriteResponseDto, httpHeaders, HttpStatus.OK);
    }
}
