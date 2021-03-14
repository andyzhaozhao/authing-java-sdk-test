package com.example.authingjavasdktest.api;

import cn.authing.core.auth.AuthenticationClient;
import cn.authing.core.graphql.GraphQLException;
import cn.authing.core.mgmt.ApplicationManagementClient;
import cn.authing.core.mgmt.ManagementClient;
import cn.authing.core.types.Application;
import cn.authing.core.types.LoginByUsernameInput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ApplicationManagementClientTestController {

    private ApplicationManagementClient applicationManagementClient;

    @GetMapping(path = "/amc/listApplications")
    public List<Application> listApplications(String menuId) throws IOException, GraphQLException {
        ManagementClient managementClient = new ManagementClient("5f9d0cee4a8f5e150cf6470d", "ea4e02cd9dbff480a64813f7fe3b5cf0");
        managementClient.setHost("https://core.authing.cn");
        this.applicationManagementClient = managementClient.application();

        managementClient.requestToken().execute();

        List<Application> result = this.applicationManagementClient.listApplications().execute();
        return result;
    }

    @GetMapping(path = "/lt")
    public Boolean lt(String menuId) throws IOException, GraphQLException {
        AuthenticationClient authenticationClient = new AuthenticationClient("5f9d0cee4a8f5e150cf6470d");
        authenticationClient.setHost("https://core.authing.cn");
        String username = "test";
        String password = "andy123456";
        authenticationClient.loginByUsername(new LoginByUsernameInput(username, password)).execute();

        authenticationClient.logout().execute();
        return true;
    }
}
