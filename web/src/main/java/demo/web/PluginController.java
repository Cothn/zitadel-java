/* Copyright (C) 2022-2023 Digital Chief Company. All Rights Reserved. */
package demo.web;

import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = PluginController.BASE_URL)
public class PluginController{
    public static final String BASE_URL = "/api/1/user";

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<OidcUserInfo> getPlugin(Authentication auth) {

        return new ResponseEntity<>(((DefaultOidcUser) auth.getPrincipal()).getUserInfo(), HttpStatus.OK);
    }
}
