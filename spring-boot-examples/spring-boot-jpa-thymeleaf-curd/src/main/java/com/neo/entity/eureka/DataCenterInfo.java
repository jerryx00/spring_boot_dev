package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;

@Data
public class DataCenterInfo {
    @Builder.Default
    private String x_xclass = "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo";

    @Builder.Default
    private String name = "MyOwn";

}
