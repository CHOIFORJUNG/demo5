package com.example.demo5.service;

import com.example.demo5.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    void replyInsert(ReplyVO rvo);

    List<ReplyVO> replyList(int boardNo);

    void replyDelete(int replyNo);

    void replyUpdate(ReplyVO rvo);
}
