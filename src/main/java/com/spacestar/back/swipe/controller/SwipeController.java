package com.spacestar.back.swipe.controller;

import com.spacestar.back.global.ResponseEntity;
import com.spacestar.back.global.ResponseSuccess;
import com.spacestar.back.member.repository.MemberRepository;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import com.spacestar.back.swipe.service.SwipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/swipe")
public class SwipeController {

    private final SwipeService swipeService;

    @GetMapping("/list")
    public ResponseEntity<?> getSwipeList(@RequestHeader("UUID") String uuid,
                                          @RequestParam(value = "page",defaultValue = "0") Integer page){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page,pageSize);
        Page<SwipeListResDto> swipePage = swipeService.getSwipeList(uuid,pageable);
        return new ResponseEntity<>(ResponseSuccess.SUCCESS, swipePage);
    }
}
