package com.spacestar.back.swipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SwipeListResDto {
    private long totalMemberCount;
    private int nowPage;
    private List<Long> memberIdList;
    private boolean isLast;
}