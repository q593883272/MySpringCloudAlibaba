package com.raven.cloud.uaa.config.oauth2;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAclVoter;
import org.springframework.security.core.Authentication;

import java.util.Collection;

public class OAuthAccessDecisionVoter extends AbstractAclVoter {

    @Override
    public int vote(Authentication authentication, MethodInvocation object, Collection<ConfigAttribute> attributes) {
        return 0;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

}
