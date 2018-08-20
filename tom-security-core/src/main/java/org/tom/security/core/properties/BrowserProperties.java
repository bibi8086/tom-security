package org.tom.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 浏览器web端配置
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/31 上午1:12
 */
@ConfigurationProperties(prefix = "tom.security.browser")
public class BrowserProperties {

    private String loginPage = "/tom-signIn.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
