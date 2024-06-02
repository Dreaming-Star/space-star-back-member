package com.spacestar.back.profile.service;

import com.spacestar.back.profile.dto.res.MemberSwipeResDto;

public interface ProfileService {

    MemberSwipeResDto findSwipeRecommend(String uuid);

    void updateSwipeRecommend(String uuid, MemberSwipeResDto memberSwipeResDto);
}
