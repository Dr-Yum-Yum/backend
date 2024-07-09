package com.yumyum.backend.plan.controller;

import com.yumyum.backend.member.repository.MemberRepository;
import com.yumyum.backend.plan.repository.PlanParticipantRepository;
import com.yumyum.backend.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final MemberRepository memberRepository;

    @GetMapping
    public Page<> findPlans(Authentication authentication, RequestFindPlanDto requestFindPlanDto){
        authentication.
    }
}
