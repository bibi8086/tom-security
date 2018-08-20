package org.tom.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图片验证码
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/3 下午11:36
 */

public class ImageCode {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public ImageCode() {
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpried(){
        return LocalDateTime.now().isAfter(expireTime);
    }


}
