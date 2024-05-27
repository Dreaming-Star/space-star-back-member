package com.spacestar.back.swipe.service;

import com.spacestar.back.swipe.dto.SwipeListResDto;

import java.util.List;

public interface SwipeService {
    List<SwipeListResDto> getSwipeList(String uuid);
}
