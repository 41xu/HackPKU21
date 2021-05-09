package com.jimo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jimo.model.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author algorithm
 */
@RestController
@RequestMapping("/canteen")
public class CanteenController {

    @GetMapping("/status")
    public Result getCanteenStatus() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://portal.pku.edu.cn/portal2017/publicsearch/canteen/retrCarteenInfos.do"))
                .build();
        JSONObject response = JSON.parseObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        return new Result(200, "", response);
    }
}
