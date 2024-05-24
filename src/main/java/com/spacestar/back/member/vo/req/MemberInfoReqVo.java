package com.spacestar.back.member.vo.req;

import com.spacestar.back.member.dto.req.MemberInfoGameReqDto;
import com.spacestar.back.member.enums.GenderType;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class MemberInfoReqVo {

    @Size(min = 2, max = 20, message = "닉네임은 2 ~ 20자리까지 가능합니다.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]*$", message = "한글, 영어(소문자, 대문자), 숫자만 입력 가능합니다.")
    private String nickname;

    @Pattern(regexp = "^[가-힣a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"|,.<>/?~]{1,30}$", message = "30자 이내로 입력 가능합니다.")
    private String description;

    private GenderType gender;

    private LocalDate birth;

    private Long gamePreferenceId;

    private List<Long> likedGameIds;

    private List<MemberInfoGameReqDto> playGames;

    private Long mainGameId;

    private Long mbtiId;

    private boolean swipe;
}
