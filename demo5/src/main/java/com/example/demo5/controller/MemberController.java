package com.example.demo5.controller;

import com.example.demo5.service.MemberService;
import com.example.demo5.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberService msvc;
    PasswordEncoder passwordEncoder;
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String insertMemberGET() {
        return "/thymeleaf/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String insertMemberPOST(@ModelAttribute(name = "mvo") MemberVO mvo) {

        String hashPw = BCrypt.hashpw(mvo.getUserPass(), BCrypt.gensalt());
        mvo.setUserPass(hashPw);
        msvc.insertMember(mvo);
        return "redirect:/list";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signinGET(){
        return "/thymeleaf/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signinPOST(MemberVO mvo, HttpServletRequest req, RedirectAttributes rtta){

        MemberVO memberVO = msvc.signinMember(mvo);
        HttpSession session = req.getSession();
//        boolean passMatch = BCrypt.checkpw(mvo.getUserPass(), memberVO.getUserPass());


        if (memberVO != null && BCrypt.checkpw(mvo.getUserPass(), memberVO.getUserPass())){
            session.setAttribute("member", memberVO);
        } else {
            session.setAttribute("member", null);
            rtta.addFlashAttribute("msg", false);
            return "redirect:/signin";
        }
        return "redirect:/index";
    }
}
