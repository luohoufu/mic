package io.tonny.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Value("${status:OK}")
    private String status;

    @RequestMapping("/status")
    public String status() {

        LOGGER.info("The status is {}", status);
        return "heath check status: " + status;
    }

}
