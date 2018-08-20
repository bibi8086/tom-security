package org.tom.dto;

/**
 * 文件
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午6:11
 */
public class FileInfo {

    private String id;

    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileInfo() {
    }

    public FileInfo(String id, String path) {
        this.id = id;
        this.path = path;
    }
}
