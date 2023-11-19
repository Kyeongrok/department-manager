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
            // 데이터를 입력받을 dto만들기
            @RequestBody MachineCreateRequestDto requestDto
    ) {
        // DTO를 Entity로
        MachineEntity machineEntity = new MachineEntity(UUID.randomUUID().toString(), requestDto.getName(), requestDto.isEnabled());

        // Entity저장하기
        MachineEntity savedMachineEntity = machineRepository.save(machineEntity);

        // 저장한 값 return
        return ResponseEntity.ok(savedMachineEntity);
    }
}
