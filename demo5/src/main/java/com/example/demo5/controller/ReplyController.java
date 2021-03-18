package com.example.demo5.controller;

import com.example.demo5.service.ReplyService;
import com.example.demo5.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/replies")
public class ReplyController {

    @Autowired
    private ReplyService rsvc;

    @RequestMapping(value = "/all/{boardNo}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> reRead(@PathVariable("boardNo") int boardNo) {
        ResponseEntity<Map<String, Object>> entity = null;
        try {
            List<ReplyVO> replyList = rsvc.replyList(boardNo);
            Map<String, Object> reMap = new HashMap<>();
            reMap.put("replyList", replyList);
            entity = new ResponseEntity<Map<String, Object>>(reMap, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo) {   //@ModelAttribute와 동일. 객체. json용

        ResponseEntity<String> entity = null;
        try {
            rsvc.replyInsert(rvo);
            entity = new ResponseEntity<String>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
