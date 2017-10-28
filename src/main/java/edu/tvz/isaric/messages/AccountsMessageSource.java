package edu.tvz.isaric.messages;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class AccountsMessageSource extends ResourceBundleMessageSource
{
    public AccountsMessageSource()
    {
        super();
        setBasename("base");
    }

}
