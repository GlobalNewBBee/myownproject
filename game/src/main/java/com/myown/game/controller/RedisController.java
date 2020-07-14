package com.myown.game.controller;

import com.myown.game.constant.CommonResponse;
import com.myown.game.constant.TestAnnotation;
import com.myown.game.log.aspect.LogAspect;
import com.myown.game.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/redis")
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    //@TestAnnotation
    @RequestMapping(value = "/testLink",produces = {"application/json;charset = UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public CommonResponse testLink(@RequestParam String stringParam){

        CommonResponse response = new CommonResponse();
        response.success("测试联通");
        System.out.println("测试联通: "+stringParam);
        return response;
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public CommonResponse getAllEntries(){
        CommonResponse response = new CommonResponse();
        try{
            Map<String, Object> map = redisService.hentries();
            response.success("业务处理成功",map);
        }catch(Exception ex){
            ex.printStackTrace();
            response.fail("业务处理失败");
        }finally {
            return response;
        }
    }

}
