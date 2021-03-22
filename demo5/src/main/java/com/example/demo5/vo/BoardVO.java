package com.example.demo5.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    private Integer boardNo;
    private int viewCnt;
    private Date regDate;
    private Integer replyCnt;
    private String userId;
    private String boardTitle;
    private String boardContents;

}