package com.example.demo5.dao;

import com.example.demo5.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public void insertMember(MemberVO mvo){
        sqlSession.insert("insertMember", mvo);
    }

    @Override
    public MemberVO signinMember(MemberVO mvo) {
        return sqlSession.selectOne("signinMember", mvo);
    }
}
