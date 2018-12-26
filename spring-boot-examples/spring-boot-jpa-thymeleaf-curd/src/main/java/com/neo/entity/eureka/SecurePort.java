package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;

@Data
public class SecurePort {
    @Builder.Default
    private String y_y = "443";
    @Builder.Default
    private String x_xenabled = "false";
}
