package ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.sec_config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer{
    public SecurityInitializer() {
        super(SecurityConfiguration.class);
    }
}

