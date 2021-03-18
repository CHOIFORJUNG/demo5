package com.example.demo5.controller;

import com.example.demo5.service.BoardService;
import com.example.demo5.vo.BoardVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {

    @Autowired
    private BoardService bsvc;

    @GetMapping(value = "/index")
    public String index(){
        return "thymeleaf/index";}

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", bsvc.list());
        return "thymeleaf/list";
    }

    @GetMapping(value = "/register")
    public String insertGET() {

        return "thymeleaf/register";
    }

    @PostMapping(value = "/register")
    public String insertPOST(@ModelAttribute(name = "bvo") BoardVO bvo) { //받아오는걸 오브젝트형태로 매핑
        bsvc.insert(bvo);
        return "redirect:/list";
    }

    @GetMapping(value = "/read")
    public String read(Model model, @RequestParam("boardNo") int boardNo){ //받아오는걸 파라미터 1:1 매핑
        model.addAttribute("readVO", bsvc.read(boardNo));
                return "thymeleaf/read";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(int boardNo, RedirectAttributes attr){
        bsvc.delete(boardNo);
        attr.addFlashAttribute("result", "Success");
        return "redirect:/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updataGET(Model model, @RequestParam("boardNo") int boardNo){
        model.addAttribute("bvo", bsvc.read(boardNo));
        return "thymeleaf/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(@ModelAttribute(name = "bvo") BoardVO bvo){
        bsvc.update(bvo);
        return "redirect:/list";
    }
}
