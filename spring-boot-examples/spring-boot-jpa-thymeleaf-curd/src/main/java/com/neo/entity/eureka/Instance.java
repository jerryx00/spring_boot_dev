package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class Instance {
    @JsonProperty("instance")
    private InstanceDetail instance;

}
