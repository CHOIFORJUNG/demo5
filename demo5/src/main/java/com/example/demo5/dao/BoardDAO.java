package com.example.demo5.dao;

import com.example.demo5.vo.BoardVO;

import java.util.List;

public interface BoardDAO {

    List<BoardVO> list();

    void insert(BoardVO bvo);

    BoardVO read(int boardNo);

    void delete(int boardNo);

    void update(BoardVO bvo);

    void viewUp(int boardNo);

}
