package io.tonny.portal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tonny.Luo
 *         健康测试用的
 */
@RestController
@RefreshScope
public class StatusController {
    @Value("${status:OK}")
    String status;

    @RequestMapping("/status")
    public String status() {
        return "heath check status: " + status;
    }

}
