package com.example.lkh.usermanagement.controllers;

        import com.example.lkh.usermanagement.dto.User;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.servlet.ModelAndView;

        import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user",new User());//object user binding data
        return mav;
    }
    @PostMapping(value = "/login-process")
    public ModelAndView loginprocess(User user, HttpSession session){
        System.out.println(user); //print user
        session.setAttribute("user", user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/"); //Redirect to home
        return mav;
    }
}
