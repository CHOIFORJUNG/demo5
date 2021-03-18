package com.example.demo5.service;

import com.example.demo5.dao.BoardDAO;
import com.example.demo5.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO bdao;

    @Override
    public List<BoardVO> list() {
        return bdao.list();
    }

    @Override
    public void insert(BoardVO bvo) {
        bdao.insert(bvo);
    }

    @Override
    public BoardVO read(int boardNo) {
        bdao.viewUp(boardNo);
        return bdao.read(boardNo);
    }

    @Override
    public void delete(int boardNo) {
        bdao.delete(boardNo);
    }

    @Override
    public void update(BoardVO bvo) {
        bdao.update(bvo);
    }

}
