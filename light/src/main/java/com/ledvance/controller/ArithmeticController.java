package com.ledvance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ArithmeticController {

    @PostMapping("arithmetic")
    public String arithmetic(File fullFileName){
//        if(!fullFileName.exists()){
//            try {
//                fullFileName.createNewFile();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//        BufferedWriter out = null;
//        try {
//            out = new BufferedWriter(new FileWriter(fullFileName));
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        out.write(inputString);
//        out.flush();
//        out.close();
//        Thread.sleep(200);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    String[] commands = {"cmd.exe", "/c", "autolayout.exe", fileName};
//
//    StringBuilder result = ExternalProgramRunner.run(commands, directory);
        return "";
    }
}
