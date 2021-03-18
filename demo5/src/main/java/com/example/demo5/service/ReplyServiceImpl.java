package com.example.demo5.service;

import com.example.demo5.dao.ReplyDAO;
import com.example.demo5.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDAO rdao;

    @Override
    public void replyInsert(ReplyVO rvo) {
        rdao.replyInsert(rvo);
    }

    @Override
    public List<ReplyVO> replyList(int boardNo) {
        return rdao.replyList(boardNo);
    }
}
