package com.spacestar.back.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spacestar.back.swipe.dto.SwipeListResDto;
import lombok.RequiredArgsConstructor;
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
    //todo 잘 맞는 순으로 조회
            List<Long> memberIds = query.select(member.id)
                    .from(member)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetch();

            long total = query.selectFrom(member)
                    .fetchCount();

        return SwipeListResDto.builder()
                    .totalMemberCount(total)
                    .nowPage(pageable.getPageNumber())
                    .memberIdList(memberIds)
                    .isLast(pageable.getOffset() + pageable.getPageSize() >= total)
                    .build();
        }
    }

