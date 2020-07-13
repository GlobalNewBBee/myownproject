package com.myown.game.controller;

import com.myown.game.constant.CommonResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/redis")
@RestController
public class RedisController {

    @RequestMapping(value = "/testLink",consumes = {"application/json;charset = UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse testLink(@RequestParam String stringParam){
        CommonResponse response = new CommonResponse();
        response.success("测试联通");
        System.out.println("测试联通: "+stringParam);
        return response;
    }
}
