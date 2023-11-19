package com.golfzone.sales.machine.controller;

import com.golfzone.sales.infra.entity.MachineEntity;
import com.golfzone.sales.infra.entity.MachineRepository;
import com.golfzone.sales.machine.dto.MachineCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/machines")
@RequiredArgsConstructor
public class MachineController {

    private final MachineRepository machineRepository;

    @GetMapping("{machineId}")
    public ResponseEntity<MachineEntity> get(
            @PathVariable String machineId
    ) {
        MachineEntity machineEntity = machineRepository.findById(machineId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s 가 없습니다.", machineId)));
        return ResponseEntity.ok(machineEntity);
    }

    @PostMapping
    public ResponseEntity<MachineEntity> create(
            @RequestBody MachineCreateRequestDto requestDto
    ) {

        MachineEntity machineEntity = new MachineEntity(UUID.randomUUID().toString(), requestDto.getName(), requestDto.isEnabled());
        MachineEntity savedMachineEntity = machineRepository.save(machineEntity);

        return ResponseEntity.ok(savedMachineEntity);
    }
}
