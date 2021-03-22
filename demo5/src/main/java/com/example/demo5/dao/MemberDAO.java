package com.example.demo5.dao;

import com.example.demo5.vo.MemberVO;

public interface MemberDAO {

    void insertMember(MemberVO mvo);

    MemberVO signinMember(MemberVO mvo);

}
