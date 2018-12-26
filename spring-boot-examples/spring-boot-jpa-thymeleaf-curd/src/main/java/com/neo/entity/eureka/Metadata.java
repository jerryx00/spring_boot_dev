package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;

@Data
public class Metadata {
    @Builder.Default
    private String x_xclass = "java.util.Collections$EmptyMap";
}
