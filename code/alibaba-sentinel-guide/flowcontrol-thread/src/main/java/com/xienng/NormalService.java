package com.xienng;


import org.springframework.stereotype.Service;

@Service
public class NormalService {


    public String normal() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
