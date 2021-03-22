package com.example.demo5.dao;

import com.example.demo5.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
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

    @Override
    public void replyDelete(int replyNo) {
        sqlSession.delete("replyDelete", replyNo);
    }

    @Override
    public void replyUpdate(ReplyVO rvo) {
        sqlSession.update("replyUpdate", rvo);
    }

    @Override
    public int getBoardNo(int replyNo) {
        return sqlSession.selectOne("getBoardNo", replyNo);
    }
}
