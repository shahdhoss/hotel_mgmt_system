package com.example.hotel.service;

import com.example.hotel.entity.Room;
import com.example.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public List<Room> viewRooms(){
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }
    public String getRoomPicture(Long id){
        Optional<Room>  optionalRoom= roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            Room room=optionalRoom.get();
            return room.getPicture();
        }

        throw new IllegalArgumentException("No picture found for room ID: " + id);

    }
}
