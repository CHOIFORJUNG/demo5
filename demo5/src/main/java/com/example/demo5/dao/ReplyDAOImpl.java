package com.example.demo5.dao;

import com.example.demo5.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void replyInsert(ReplyVO rvo){
        sqlSession.insert("replyInsert", rvo);
    }

    @Override
    public List<ReplyVO> replyList(int boardNo) {
        return sqlSession.selectList("replyList", boardNo);
    }
}
