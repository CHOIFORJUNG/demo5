package com.example.demo5.vo;

import lombok.Data;

@Data
public class ReplyVO {

    private int reply_no;
    private int board_no;
    private String reply_contents;
    private String reply_writer;

}
