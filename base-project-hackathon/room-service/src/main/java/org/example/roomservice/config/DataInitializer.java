package org.example.roomservice.config;

import org.example.roomservice.model.Room;
import org.example.roomservice.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoomData(RoomRepository roomRepository) {
        return args -> {
            if (roomRepository.count() == 0) {
                roomRepository.save(new Room(null, "101", 1L, 500000.0, "AVAILABLE"));
                roomRepository.save(new Room(null, "102", 1L, 500000.0, "AVAILABLE"));
                roomRepository.save(new Room(null, "201", 2L, 300000.0, "AVAILABLE"));
                roomRepository.save(new Room(null, "202", 2L, 300000.0, "OCCUPIED"));
                roomRepository.save(new Room(null, "301", 3L, 800000.0, "AVAILABLE"));
                roomRepository.save(new Room(null, "401", 4L, 1200000.0, "AVAILABLE"));
                System.out.println("=== Đã khởi tạo 6 phòng mẫu ===");
            }
        };
    }
}
