package com.digital.crud.saladereuniao.controller;

import com.digital.crud.saladereuniao.exception.ResourceNotFoundException;
import com.digital.crud.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/name/{name}")
    public List<Room> getRoomByName(@PathVariable(value = "name") String name) {
        List<Room> rooms = roomRepository.findAll();
        if(!name.isEmpty()) {
            rooms = rooms.stream().filter(p -> p.getName().
                    toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        return rooms;
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long roomId)
            throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found :: " + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));

        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom = roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId)
            throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}