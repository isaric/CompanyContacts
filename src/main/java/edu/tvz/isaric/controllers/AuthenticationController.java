package edu.tvz.isaric.controllers;

import edu.tvz.isaric.facades.authentication.AuthenticationFacade;
import edu.tvz.isaric.facades.data.UserData;
import edu.tvz.isaric.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class AuthenticationController
{
    private AuthenticationFacade authenticationFacade;

    @Autowired
    public AuthenticationController(AuthenticationFacade authenticationFacade)
    {
        this.authenticationFacade = authenticationFacade;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserData doLogin(
            @RequestBody
                    LoginForm login)
    {
        return authenticationFacade.authenticate(login);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public UserData doLogout(HttpServletRequest request)
    {
        return authenticationFacade.logout(request);
    }
}
