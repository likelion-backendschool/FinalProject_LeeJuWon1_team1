package com.ll.ebookmarket.app.member.service;

import com.ll.ebookmarket.app.member.entity.Member;
import com.ll.ebookmarket.app.member.exception.MemberNotFoundException;
import com.ll.ebookmarket.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member create(String username, String password, String email, String nickname) {

        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .nickname("")
                .authLevel((nickname != null) ? 3 : 4)
                .build();

        memberRepository.save(member);

        return member;
    }

    public Member findByUsername(String email) {

        Optional<Member> member = this.memberRepository.findByUsername(email);

        if (member.isEmpty()) {
            throw new MemberNotFoundException();
        }

        return member.get();
    }

    public List<Member> findByEmail(String email) {

        List<Member> memberList = this.memberRepository.findByEmail(email);

        if (memberList.isEmpty()) {
            throw new MemberNotFoundException();
        }

        return memberList;
    }

    public void modifyPassword(Member member, String password) {
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
    }
}
