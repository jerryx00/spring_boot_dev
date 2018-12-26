package com.neo.entity.eureka;

import lombok.Builder;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class InstanceDetail {
    @JsonProperty("instance_id")
    private String instanceId = "";

    @Builder.Default
    private String app = "jzt-patrol-adaptor";

    @JsonProperty("app_group_name")
    private String appGroupName;

    @JsonProperty("ip_addr")
    private String ipAddr;

    @Builder.Default
    private String sid = "na";

    private String homePageUrl;
    private String healthCheckUrl;
    private String secureHealthCheckUrl;
    private String vipAddress;
    private String secureVipAddress;

    @Builder.Default
    private String countryId = "1";
    private DataCenterInfo dataCenterInfo;

    private String hostName;
    @Builder.Default
    private String statusPageUrl = "UP";
    @Builder.Default
    private String leaseInfo = null;
    @Builder.Default
    private boolean isCoordinatingDiscoveryServer = false;
    private String lastUpdatedTimestamp;
    private String lastDirtyTimestamp;
    @Builder.Default
    private String actionType = null;
    @Builder.Default
    private String asgName = null;
    @Builder.Default
    private String overridden_status = "UNKNOWN";

    private Port port;
    private SecurePort securePort;

    private Metadata metadata;

}
