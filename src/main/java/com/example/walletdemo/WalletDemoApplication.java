package com.example.walletdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class WalletDemoApplication {

    @Autowired
    private BtcService btcService;

    public static void main(String[] args) {
        SpringApplication.run(WalletDemoApplication.class, args);
    }

    @GetMapping("/getAddress")
    public String getAddress(){
        return btcService.getBlockCount();
    }
}
