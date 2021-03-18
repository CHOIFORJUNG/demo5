package com.example.demo5.service;

import com.example.demo5.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> list();

    void insert(BoardVO bvo);

    BoardVO read(int boardNo);

    void delete(int boardNo);

    void update(BoardVO bvo);

}
