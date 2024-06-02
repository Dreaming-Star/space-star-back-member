package com.spacestar.back.profile.controller;

import com.spacestar.back.global.ResponseEntity;
import com.spacestar.back.global.ResponseSuccess;
import com.spacestar.back.profile.dto.res.MemberSwipeResDto;
import com.spacestar.back.profile.service.ProfileService;
import com.spacestar.back.profile.vo.res.MemberSwipeResVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Profile", description = "프로필")
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;
    private final ModelMapper mapper;

    @Operation(summary = "스와이프 추천 여부 조회")
    @GetMapping("/swipe/recommend")
    public ResponseEntity<MemberSwipeResVo> swipeRecommend(@RequestHeader("UUID") String uuid){

        return new ResponseEntity<>(ResponseSuccess.SWIPE_RECOMMEND_SELECT_SUCCESS,
                mapper.map(profileService.findSwipeRecommend(uuid), MemberSwipeResVo.class));
    }

    @Operation(summary = "스와이프 추천 여부 변경")
    @PatchMapping("/swipe/recommend/update")
    public ResponseEntity<Void> swipeRecommendUpdate(@RequestHeader("UUID") String uuid,
                                                     @RequestBody MemberSwipeResVo memberSwipeResVo) {

        profileService.updateSwipeRecommend(uuid, mapper.map(memberSwipeResVo, MemberSwipeResDto.class));
        return new ResponseEntity<>(ResponseSuccess.SWIPE_RECOMMEND_UPDATE_SUCCESS);
    }

}
