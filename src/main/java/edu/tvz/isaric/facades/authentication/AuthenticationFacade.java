package edu.tvz.isaric.facades.authentication;

import edu.tvz.isaric.facades.data.UserData;
import edu.tvz.isaric.forms.LoginForm;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationFacade
{
    UserData authenticate(LoginForm loginForm);

    UserData logout(HttpServletRequest request);
}
