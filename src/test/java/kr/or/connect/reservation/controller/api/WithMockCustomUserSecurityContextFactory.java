package kr.or.connect.reservation.controller.api;

import kr.or.connect.reservation.service.security.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {

    @Override
    public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        CustomUserDetails principal = new CustomUserDetails(customUser.userId(), customUser.username(), "1234");
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, "1234", principal.getAuthorities());
        context.setAuthentication(authentication);
        return context;
    }
}
