package hight.sa;

import hight.sa.model.LoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class LoginController {

    @PostMapping("/doLogin")
    public String login(
            @ModelAttribute("LoginUser") LoginUser loginUser,
            Model model,
            HttpSession session) {
        if (!StringUtils.startsWith(loginUser.getEmail(), "neron")) {
            model.addAttribute("message", "User not exist!");
            return "login";
        }

        return "index";
    }


}
