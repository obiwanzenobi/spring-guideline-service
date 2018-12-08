package pl.lightmobile.guidelineservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import pl.lightmobile.guidelineservice.authorization.UserConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfiguration {
    private List<UserConfiguration> users = new ArrayList<>();
    private String clientId;
    private String clientSecret;

    public List<UserConfiguration> getUsers() {
        return users;
    }

    public void setUsers(List<UserConfiguration> users) {
        this.users = users;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
