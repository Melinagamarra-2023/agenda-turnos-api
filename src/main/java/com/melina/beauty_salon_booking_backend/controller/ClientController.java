package com.melina.beauty_salon_booking_backend.controller;

import com.melina.beauty_salon_booking_backend.dto.ClientRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ClientResponseDto;
import com.melina.beauty_salon_booking_backend.security.util.DecodeUtil;
import com.melina.beauty_salon_booking_backend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final DecodeUtil decodeUtil;

    public ClientController(ClientService clientService, DecodeUtil decodeUtil1) {
        this.clientService = clientService;
        this.decodeUtil = decodeUtil1;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody @Valid ClientRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(request));
    }

    @GetMapping("/me")
    public ResponseEntity<ClientResponseDto> getClientByCuit(@RequestHeader("Authorization") String authorizationHeader) {
        String cuit = decodeUtil.extractCuit(authorizationHeader);
        return ResponseEntity.ok(clientService.getClientByCuit(cuit));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PutMapping
    public ResponseEntity<ClientResponseDto> updateClient(@RequestHeader("Authorization") String authorization,
                                                          @RequestBody @Valid ClientRequestDto request) {
        String cuit = decodeUtil.extractCuit(authorization);
        return ResponseEntity.ok(clientService.updateClient(cuit, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClient(@RequestHeader ("Authorization") String authorization) {
        String cuit = decodeUtil.extractCuit(authorization);
        clientService.deleteClient(cuit);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClientResponseDto> getClientByDni(@PathVariable String dni) {
        return ResponseEntity.ok(clientService.getClientByDni(dni));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientResponseDto> getClientByEmail(@PathVariable String email) {
        return ResponseEntity.ok(clientService.getClientByEmail(email));
    }

    @PatchMapping("/{id}/enable")
    public ResponseEntity<ClientResponseDto> enableClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.enableClient(id));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<ClientResponseDto> disableClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.disableClient(id));
    }


}

