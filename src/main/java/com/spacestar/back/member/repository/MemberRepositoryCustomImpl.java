package com.spacestar.back.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.spacestar.back.member.domain.QMember.member;

@RequiredArgsConstructor
@Component
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory query;

    @Override
    public SwipeListResDto findSwipeLists(Pageable pageable) {

            List<Long> memberIds = query.select(member.id)
                    .from(member)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetch();

            long total = query.selectFrom(member)
                    .fetchCount();

            SwipeListResDto swipeListResDto = SwipeListResDto.builder()
                    .totalMemberCount(total)
                    .nowPage(pageable.getPageNumber())
                    .memberIdList(memberIds)
                    .isLast(pageable.getOffset() + pageable.getPageSize() >= total)
                    .build();

            return swipeListResDto;
        }
    }

