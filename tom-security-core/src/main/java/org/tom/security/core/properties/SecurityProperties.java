package org.tom.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security配置
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/31 上午1:11
 */
@ConfigurationProperties(prefix = "tom.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(ValidateCodeProperties validateCode) {
        this.validateCode = validateCode;
    }
}
