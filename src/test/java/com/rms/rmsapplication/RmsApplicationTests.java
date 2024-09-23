package com.rms.rmsapplication;

import com.rms.rmsapplication.security.repositories.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.test.annotation.Commit;

import java.util.UUID;

@SpringBootTest
class RmsApplicationTests {
        @Autowired
    private JpaRegisteredClientRepository registeredClientRepository;
    @Test
    void contextLoads() {
    }

    @Test
    @Commit
    void storeRegisteredClientIntoDB() {
                RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("oidc-client")
                .clientSecret("$2a$16$KSNZ0mn655IxKH3KlxOdsO.3gAL7WlciVpd.hnXjoo.Mv35mMdFf2")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("https://oauth.pstmn.io/v1/callback")
                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .scope("ADMIN")
                .scope("MANAGER")
                .scope("RECRUITER")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();

                registeredClientRepository.save(oidcClient);

    }

}
