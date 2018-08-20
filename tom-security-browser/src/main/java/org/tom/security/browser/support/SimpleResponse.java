package org.tom.security.browser.support;

/**
 * TODO 添加注释
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/31 上午1:03
 */

public class SimpleResponse {

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
