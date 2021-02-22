package com.example.authingjavasdktest.api;

import cn.authing.core.graphql.GraphQLException;
import cn.authing.core.mgmt.ApplicationManagementClient;
import cn.authing.core.mgmt.ManagementClient;
import cn.authing.core.types.Application;
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
}
