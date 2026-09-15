package org.example.roomservice.service;

import feign.FeignException;
import org.example.roomservice.client.RoomTypeFeignClient;
import org.example.roomservice.model.Room;
import org.example.roomservice.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeFeignClient roomTypeFeignClient;

    public RoomService(RoomRepository roomRepository, RoomTypeFeignClient roomTypeFeignClient) {
        this.roomRepository = roomRepository;
        this.roomTypeFeignClient = roomTypeFeignClient;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null");
        }
        if (room.getRoomNumber() == null || room.getRoomNumber().isBlank()) {
            throw new IllegalArgumentException("Room number is required");
        }
        if (room.getRoomTypeId() == null || room.getRoomTypeId() <= 0) {
            throw new IllegalArgumentException("Room type id must be a positive number");
        }

        try {
            roomTypeFeignClient.getRoomTypeById(room.getRoomTypeId());
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException("RoomType not found with id: " + room.getRoomTypeId());
        } catch (FeignException e) {
            throw new IllegalStateException("Unable to validate room type with id: " + room.getRoomTypeId(), e);
        }

        return roomRepository.save(room);
    }
}
