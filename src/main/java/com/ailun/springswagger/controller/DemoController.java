package com.ailun.springswagger.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author leon
 */
@RestController
@RequestMapping("/demo")
@Api("demoApi document")
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @ApiOperation("invoke demo api")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "sid", dataType = "String", required = true, value = "session id", defaultValue = "abc123"),
            @ApiImplicitParam(paramType = "query", name = "demo", dataType = "String", required = true, value = "demo param", defaultValue = "demo param")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "invalid request params"),
            @ApiResponse(code = 404, message = "invalid request")
    })
    @ResponseBody
    @RequestMapping(value = {"/demoAPI"}, method = RequestMethod.GET)
    public String demoApi(@RequestHeader("sid") String sid, @RequestParam("demo") String demo) {
        logger.info("do demo api");
        return "welcome";
    }
}
