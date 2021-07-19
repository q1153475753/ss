package com.ledvance.controller;

import com.ledvance.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
public class Test1 {

    @Autowired
    private SpaceService spaceService;

    @ResponseBody
    @PostMapping("/lightLayout")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public String space(@RequestBody String space) {

        return spaceService.space(space);
    }
}
