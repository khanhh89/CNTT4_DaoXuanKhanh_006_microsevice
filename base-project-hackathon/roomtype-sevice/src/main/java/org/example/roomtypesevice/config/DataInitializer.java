package org.example.roomtypesevice.config;

import org.example.roomtypesevice.model.RoomType;
import org.example.roomtypesevice.repository.RoomTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoomTypeData(RoomTypeRepository roomTypeRepository) {
        return args -> {
            if (roomTypeRepository.count() == 0) {
                roomTypeRepository.save(new RoomType(null, "Deluxe", "Phòng cao cấp với view biển"));
                roomTypeRepository.save(new RoomType(null, "Standard", "Phòng tiêu chuẩn"));
                roomTypeRepository.save(new RoomType(null, "Suite", "Phòng suite sang trọng"));
                roomTypeRepository.save(new RoomType(null, "VIP", "Phòng VIP hạng thương gia"));
                System.out.println("=== Đã khởi tạo 4 loại phòng mẫu ===");
            }
        };
    }
}
