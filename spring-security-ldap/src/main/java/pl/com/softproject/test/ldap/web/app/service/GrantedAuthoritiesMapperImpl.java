package pl.com.softproject.test.ldap.web.app.service;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class GrantedAuthoritiesMapperImpl
 *
 * @author Marcin Jasinski {@literal <mkjasinski@gmail.com>}
 */
public class GrantedAuthoritiesMapperImpl implements GrantedAuthoritiesMapper {

    private static final Logger logger = Logger.getLogger(GrantedAuthoritiesMapperImpl.class);

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> grantedAuthorities) {

        List<GrantedAuthority> mappedAuthorities = new ArrayList<>();

        for (GrantedAuthority grantedAuthority : grantedAuthorities) {

            String authority = grantedAuthority.getAuthority().toLowerCase();

            mappedAuthorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", authority.toUpperCase())));
        }

        return mappedAuthorities;
    }
}
