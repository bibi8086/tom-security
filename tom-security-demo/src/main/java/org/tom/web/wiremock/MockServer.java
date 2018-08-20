package org.tom.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * WireMock服务
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午11:03
 */

public class MockServer {

    public static void main(String[] args) throws IOException {
        WireMock.configureFor(9100);
        WireMock.removeAllMappings();

        mock("/users/1", "01.txt");
        mock("/users/2", "02.txt");
    }

    private static void mock(String url, String filename) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mock/response/" + filename);
        String content = StringUtils.join(FileUtils.readLines(classPathResource.getFile(), "UTF-8").toArray(), "\n");
        System.out.println(content);
        WireMock.stubFor(
                WireMock.get(WireMock.urlPathEqualTo(url))
                        .willReturn(WireMock.okJson(content))
        );
    }
}
