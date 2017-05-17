package io.tonny.portal.controller;

import io.tonny.portal.json.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tonny.Luo
 *         全局异常处理
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class GlobalErrorController extends AbstractErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorController.class);

    @Autowired
    public GlobalErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status.is5xxServerError()) {
            if (HttpStatus.NOT_FOUND == status) {
                return new ResponseEntity(new AjaxResult().failure("server inner error"), status);
            }
            LOGGER.error("{} request with {}!", request.getRequestURL(), status);
        }
        if (status.is4xxClientError()) {
            if (HttpStatus.NOT_FOUND == status) {
                return new ResponseEntity(new AjaxResult().failure("page not found"), status);
            }
            LOGGER.error("{} request with {}!", request.getRequestURL());
        }

        return new ResponseEntity(new AjaxResult().failure("server error"), status);
    }
}
