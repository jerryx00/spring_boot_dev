package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;

@Data
public class Port {
    @Builder.Default
    private String y_y = "8766";
    @Builder.Default
    private String x_xenabled = "true";
}
