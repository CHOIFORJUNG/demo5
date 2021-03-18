package com.example.demo5.dao;

import com.example.demo5.vo.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    void replyInsert(ReplyVO rvo);

    List<ReplyVO> replyList(int boardNo);
}
