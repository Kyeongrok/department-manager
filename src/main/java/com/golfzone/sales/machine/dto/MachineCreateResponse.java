package com.golfzone.sales.machine.dto;

import com.golfzone.sales.infra.entity.MachineEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MachineCreateResponse {
    private String id;
    private String name;
    private String enabled;

    public static MachineCreateResponse fromEntity(MachineEntity machineEntity) {

        // true/false를 On/Off로 변경
        return MachineCreateResponse.builder()
                .id(machineEntity.getId())
                .name(machineEntity.getName())
                .enabled(machineEntity.isEnabled() ? "On" : "Off")
                .build();
    }
}
