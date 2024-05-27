package com.spacestar.back.swipe.controller;

import com.spacestar.back.global.ResponseEntity;
import com.spacestar.back.global.ResponseSuccess;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import com.spacestar.back.swipe.service.SwipeService;
import com.spacestar.back.swipe.vo.SwipeListResVo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/swipe")
public class SwipeController {

    private final SwipeService swipeService;
    private final ModelMapper mapper;

    @GetMapping("/list")
    public ResponseEntity<SwipeListResVo> getSwipeList(@RequestHeader("UUID") String uuid,
                                                       @RequestParam(value = "page", defaultValue = "0") Integer page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page, pageSize);
        SwipeListResDto swipePage = swipeService.getSwipeList(uuid, pageable);
        return new ResponseEntity<>(ResponseSuccess.SUCCESS, mapper.map(swipePage, SwipeListResVo.class));
    }
}
