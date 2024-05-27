package com.spacestar.back.swipe.service;

import com.spacestar.back.swipe.dto.SwipeListResDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface SwipeService {
    SwipeListResDto getSwipeList(String uuid, Pageable pageable);
}
