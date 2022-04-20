package com.user.user.User;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository repository;
     
   

    @GetMapping("/signup")
    public String Signup(Model m){
        m.addAttribute("user",new User() );
      
        return "signup";
    }

    @GetMapping("/login")
    public String Login(Model m){
      m.addAttribute("user", new User());
            return "Login";
    }

    @GetMapping("/welcome")
    public String  welcome(){

        return "welcome";
    }

    @Transactional
    @PostMapping("/register")
    public String Register(User user,HttpSession session) throws Exception{
       User u=repository.findByEmail(user.getEmail()); 
        if(u!=null){
            session.setAttribute("message","Email is Already Exist");
            new Exception("Email Already exist");
            return "signup";
        }else{
         
            BCryptPasswordEncoder s=new BCryptPasswordEncoder();
            String bp=s.encode(user.getPassword());
            user.setPassword(bp);
            repository.save(user);
            return "Login" ;
        }
          
    }

    @Transactional
    @PostMapping("/login")
    public String LoginCode(User use,HttpSession session,Model m)throws Exception{
     //   m.addAttribute("use",new User());
     User u1=repository.findByEmail(use.getEmail());

     if(u1!=null){
        BCryptPasswordEncoder s=new BCryptPasswordEncoder();
        String bps=s.encode(use.getPassword());
       
      boolean a=  s.matches(use.getPassword(), u1.getPassword());
         use.setPassword(bps);
        
            if(a==true){
                return "welcome";
            }else{
                session.setAttribute("message", "Enter valid Password");
                return "Login";
            }

        }else{
            session.setAttribute("message", "Enter valid Email and Password");
            return "Login";
        }
        
        }
    }
    

