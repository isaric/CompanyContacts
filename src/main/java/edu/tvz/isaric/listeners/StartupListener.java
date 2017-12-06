package edu.tvz.isaric.listeners;

import edu.tvz.isaric.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent>
{
    private UserService defaultUserService;

    @Autowired
    public StartupListener(UserService defaultUserService)
    {
        this.defaultUserService = defaultUserService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        defaultUserService.createDefaultAdmin();
    }
}
