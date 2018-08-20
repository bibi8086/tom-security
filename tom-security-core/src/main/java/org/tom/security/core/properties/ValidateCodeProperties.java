package org.tom.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 验证码配置
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/4 上午12:46
 */
@ConfigurationProperties(prefix = "tom.security.validate-code")
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
