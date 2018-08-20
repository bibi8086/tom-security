package org.tom.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 图片验证码配置
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/4 上午12:44
 */
@ConfigurationProperties(prefix = "tom.security.validate-code.image")
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;
    private String url = "";

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
