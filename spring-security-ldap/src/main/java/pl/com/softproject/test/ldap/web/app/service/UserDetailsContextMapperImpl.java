package pl.com.softproject.test.ldap.web.app.service;

import org.apache.log4j.Logger;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class UserDetailsContextMapperImpl
 *
 * @author Marcin Jasinski {@literal <mkjasinski@gmail.com>}
 */
public class UserDetailsContextMapperImpl implements UserDetailsContextMapper {

    private static final Logger logger = Logger.getLogger(UserDetailsContextMapperImpl.class);

    @Override
    public UserDetails mapUserFromContext(DirContextOperations dirContextOperations, String s, Collection<? extends GrantedAuthority> grantedAuthorities) {

        List<GrantedAuthority> mappedAuthorities = new ArrayList<>();

        for (GrantedAuthority grantedAuthority : grantedAuthorities) {

            String authority = grantedAuthority.getAuthority().toLowerCase();

            mappedAuthorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", authority.toUpperCase())));
        }

        return new User(s, "", true, true, true, true, mappedAuthorities);
    }

    @Override
    public void mapUserToContext(UserDetails userDetails, DirContextAdapter dirContextAdapter) {

    }
}
