package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.service.security.CustomUserDetails;
import kr.or.connect.reservation.service.security.UserDbService;
import kr.or.connect.reservation.service.security.UserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import javax.xml.soap.Detail;
import java.util.ArrayList;
import java.util.List;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {


    private UserDbService userdbService;

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser withMockCustomUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        List<GrantedAuthority> grantedAuthorities = new ArrayList();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        UserEntity customUser = userdbService.getUser(loginId);
        User principal = new User(customUser.username(), "1234", true, true, true, true,
                grantedAuthorities);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                principal, principal.getPassword(), principal.getAuthorities());

        authentication.setDetails(new Detail(customUser.username(), "aaaa"));
        context.setAuthentication(authentication);
        return context;
    }
}
