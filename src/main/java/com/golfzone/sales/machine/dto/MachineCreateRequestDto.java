package com.golfzone.sales.machine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MachineCreateRequestDto {
    private String name;
    private boolean enabled;
}
