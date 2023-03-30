/**
 * 
 */
package com.toppan.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MyRestController {
	protected final String blockMessage = "{\"Error\": \"You do not have permission to access this page.\"}";

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String defaultBlocker() {
        return blockMessage;
    }
}
