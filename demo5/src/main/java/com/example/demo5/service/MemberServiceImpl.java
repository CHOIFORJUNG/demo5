package com.example.demo5.service;

import com.example.demo5.dao.MemberDAO;
import com.example.demo5.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDAO mdao;

    @Override
    public void insertMember(MemberVO mvo){
        mdao.insertMember(mvo);
    }

    @Override
    public MemberVO signinMember(MemberVO mvo) {
        mdao.signinMember(mvo);
        return mvo;
    }

    @Override
    public void signoutMember(HttpSession session) {
        session.invalidate();
    }
}
