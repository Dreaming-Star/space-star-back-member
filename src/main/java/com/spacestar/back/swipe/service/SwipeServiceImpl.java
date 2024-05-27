package com.spacestar.back.swipe.service;

import com.spacestar.back.member.repository.MemberRepository;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SwipeServiceImpl implements SwipeService{
    private final MemberRepository memberRepository;

    @Override
    public Page<SwipeListResDto> getSwipeList(String uuid, Pageable pageable) {

        return memberRepository.findSwipeLists(pageable);

    }
}
