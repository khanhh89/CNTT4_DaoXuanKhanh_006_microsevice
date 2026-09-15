package org.example.roomtypesevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RoomtypeSeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomtypeSeviceApplication.class, args);
    }

}
