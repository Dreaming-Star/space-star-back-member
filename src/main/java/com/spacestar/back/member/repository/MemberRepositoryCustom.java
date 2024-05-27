package com.spacestar.back.member.repository;

import com.spacestar.back.swipe.dto.SwipeListResDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {
    SwipeListResDto findSwipeLists(Pageable pageable);
}
