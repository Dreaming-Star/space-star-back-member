package com.spacestar.back.member.vo.res;

import com.spacestar.back.member.dto.res.ProfileImageListResDto;
import lombok.Getter;

@Getter
public class ProfileImageListResVo {

    private int index;
    private String profileImageUrl;
    private boolean mainImage;
    private int imageIdx;


}
