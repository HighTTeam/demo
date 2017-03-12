package hight.sa;

import hight.sa.to.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(
            @ModelAttribute("LoginUser") LoginUser loginUser,
            Map<String, Object> model,
            HttpSession session) {
        if ("true".equals(session.getAttribute("isLoggedIn"))) {
            return "redirect:index";
        }

        if (!StringUtils.startsWith(loginUser.getEmail(), "neron") ||
                !StringUtils.startsWith(loginUser.getEmail(), "yxm")) {
            model.put("message", "User not exist!");
            return "login";
        }

        session.setAttribute("isLoggedIn", "true");
        return "redirect:index";
    }

}
