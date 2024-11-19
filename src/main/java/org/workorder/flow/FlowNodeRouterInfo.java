package org.workorder.flow;

import lombok.Data;

@Data
public class FlowNodeRouterInfo {
    private String msg;
    private String key;
    private FlowNode flowNode;
}
