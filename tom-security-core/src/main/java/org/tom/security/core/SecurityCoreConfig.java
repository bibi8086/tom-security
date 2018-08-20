package org.tom.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.tom.security.core.properties.SecurityProperties;

/**
 * TODO 添加注释
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/31 上午1:15
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
