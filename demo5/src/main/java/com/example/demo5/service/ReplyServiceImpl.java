package com.example.demo5.service;

import com.example.demo5.dao.BoardDAO;
import com.example.demo5.dao.ReplyDAO;
import com.example.demo5.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final BoardDAO bdao;

    @Autowired
    private ReplyDAO rdao;

    public ReplyServiceImpl(BoardDAO bdao){
        this.bdao = bdao;
    }
    @Transactional
    @Override
    public void replyInsert(ReplyVO rvo) {
        rdao.replyInsert(rvo);
        bdao.updateReplyCnt(rvo.getBoardNo(), 1);
    }

    @Override
    public List<ReplyVO> replyList(int boardNo) {
        return rdao.replyList(boardNo);
    }

    @Transactional
    @Override
    public void replyDelete(int replyNo) {
        int boardNo = rdao.getBoardNo(replyNo);
        rdao.replyDelete(replyNo);
        bdao.updateReplyCnt(boardNo, -1);
    }

    @Override
    public void replyUpdate(ReplyVO rvo) {
        rdao.replyUpdate(rvo);
    }


}
