package com.spacestar.back.profile.service;

import com.spacestar.back.global.GlobalException;
import com.spacestar.back.global.ResponseStatus;
import com.spacestar.back.profile.domain.Profile;
import com.spacestar.back.profile.dto.res.MemberSwipeResDto;
import com.spacestar.back.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileServiceImp implements ProfileService{

    private final ProfileRepository profileRepository;

    @Override
    public MemberSwipeResDto findSwipeRecommend(String uuid) {

        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new GlobalException(ResponseStatus.NOT_EXIST_MEMBER));

        return MemberSwipeResDto.builder()
                .swipe(profile.isSwipe())
                .build();
    }

    @Transactional
    @Override
    public void updateSwipeRecommend(String uuid, MemberSwipeResDto memberSwipeResDto) {

        Profile profile = profileRepository.findByUuid(uuid)
                .orElseThrow(() -> new GlobalException(ResponseStatus.NOT_EXIST_MEMBER));

        profileRepository.updateSwipe(uuid,memberSwipeResDto.isSwipe());
    }
}
