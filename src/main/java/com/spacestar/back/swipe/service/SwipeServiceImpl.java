package com.spacestar.back.swipe.service;

import com.spacestar.back.member.repository.MemberRepository;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwipeServiceImpl implements SwipeService{
    private final MemberRepository memberRepository;

    @Override
    public List<SwipeListResDto> getSwipeList(String uuid) {
        return null;
    }
}
