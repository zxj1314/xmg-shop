package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.service.IMQTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName
 * @Description mq测试
 * @author zhuxiaojin
 * @Date 2018-03-30
 */
@Controller
public class MQTestController {

    @Reference
    private IMQTestService imqTestService;

    @RequestMapping(value = "/mqtest",method = RequestMethod.GET)
    public void mqTest(HttpServletRequest request){
        imqTestService.sendMessage(request.getParameter("userId"));
    }
}
