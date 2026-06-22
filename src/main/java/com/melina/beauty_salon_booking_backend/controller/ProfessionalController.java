package com.melina.beauty_salon_booking_backend.controller;

import com.melina.beauty_salon_booking_backend.dto.ProfessionalRequestDto;
import com.melina.beauty_salon_booking_backend.dto.ProfessionalResponseDto;
import com.melina.beauty_salon_booking_backend.model.Professional;
import com.melina.beauty_salon_booking_backend.security.util.DecodeUtil;
import com.melina.beauty_salon_booking_backend.service.ProfessionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/professional")
public class ProfessionalController {
    private final ProfessionalService professionalService;
    private final DecodeUtil decodeUtil;

    public ProfessionalController(ProfessionalService professionalService, DecodeUtil decodeUtil, DecodeUtil decodeUtil1) {
        this.professionalService = professionalService;
        this.decodeUtil = decodeUtil1;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfessionalResponseDto> createProfessional(@RequestBody ProfessionalRequestDto request) {
        ProfessionalResponseDto response = professionalService.createProfessional(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<ProfessionalResponseDto> getProfessionalByCuit(@RequestHeader("Authorization") String autorizathion) {
        String cuit = decodeUtil.extractCuit(autorizathion);
        ProfessionalResponseDto response = professionalService.getPrefessionalByCuit(cuit);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponseDto>> getAllProfessionals() {
        return ResponseEntity.ok(professionalService.getAllProfessionals());
    }

    @GetMapping("/email")
    public ResponseEntity<ProfessionalResponseDto> getProfessionalByEmail(@RequestParam String email) {
        ProfessionalResponseDto response = professionalService.getPrefessionalByEmail(email);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/dni")
    public ResponseEntity<ProfessionalResponseDto> getProfessionalByDni(@RequestParam String dni) {
        ProfessionalResponseDto response = professionalService.getProfessionalByDni(dni);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProfessional(@RequestHeader("Authorization") String authorization) {
        String cuit = decodeUtil.extractCuit(authorization);
        professionalService.deleteProfessional(cuit);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProfessionalResponseDto> updateProfessional(
            @RequestHeader("Authorization") String authorization,
            @RequestBody ProfessionalRequestDto requestDto) {
        String cuit = decodeUtil.extractCuit(authorization);
        return ResponseEntity.ok(professionalService.updateProfessional(cuit, requestDto));

    }

    @PatchMapping("/{id}/enable")
    public ResponseEntity<ProfessionalResponseDto> enableProfessional(@PathVariable Long id) {
        return ResponseEntity.ok(professionalService.enableProfessional(id));
    }

    @PatchMapping("/{id}/disable")
    public ResponseEntity<ProfessionalResponseDto> disableProfessional(@PathVariable Long id) {
        return ResponseEntity.ok(professionalService.disableProfessional(id));
    }

}


