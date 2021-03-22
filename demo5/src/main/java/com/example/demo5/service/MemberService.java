package com.example.demo5.service;

import com.example.demo5.vo.MemberVO;

import javax.servlet.http.HttpSession;

public interface MemberService {

    void insertMember(MemberVO mvo);

    MemberVO signinMember(MemberVO mvo);

    void signoutMember(HttpSession session);
}
