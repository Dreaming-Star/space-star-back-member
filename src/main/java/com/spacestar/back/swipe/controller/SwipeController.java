package com.spacestar.back.swipe.controller;

import com.spacestar.back.global.ResponseEntity;
import com.spacestar.back.member.repository.MemberRepository;
import com.spacestar.back.swipe.service.SwipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/swipe")
public class SwipeController {

    private final SwipeService swipeService;

    @GetMapping
    public ResponseEntity<?> getSwipeList(@RequestHeader("UUID") String uuid){
        swipeService.getSwipeList(uuid);
        return null;
    }
}
