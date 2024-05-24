package com.spacestar.back.member.service;

import com.spacestar.back.member.dto.req.MemberInfoReqDto;
import com.spacestar.back.member.dto.req.ProfileImageReqDto;
import com.spacestar.back.member.dto.res.ProfileChattingResDto;
import com.spacestar.back.member.dto.res.ProfileImageListResDto;

import java.util.List;

public interface MemberService {

    void updateMemberInfo(String uuid,MemberInfoReqDto memberInfoReqDto);

    void updateProfileImages(String uuid, List<ProfileImageReqDto> profileImageReqDtos);

    List<ProfileImageListResDto> findProfileImageList(String uuid);

    ProfileImageListResDto findMainProfileImage(String uuid);

    ProfileChattingResDto findChattingProfile(String uuid);
}
