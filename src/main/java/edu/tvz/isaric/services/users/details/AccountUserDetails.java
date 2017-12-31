package edu.tvz.isaric.services.users.details;

import edu.tvz.isaric.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AccountUserDetails implements UserDetails
{
    private String password;
    private String uid;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return AuthorityUtils.createAuthorityList(role.toString());
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return uid;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    protected void setPassword(String password)
    {
        this.password = password;
    }

    protected void setUid(String uid)
    {
        this.uid = uid;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}
