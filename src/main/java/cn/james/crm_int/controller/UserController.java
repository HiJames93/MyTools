package cn.james.crm_int.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author James
 * @since 2020-05-06
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //404
    @RequestMapping("/pageERR")
    public String pageERR(){
        return "404";
    }
}
