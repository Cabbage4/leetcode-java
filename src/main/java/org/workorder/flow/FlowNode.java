package org.workorder.flow;

import java.util.List;

import lombok.Data;

@Data
public class FlowNode {
    private Integer id;

    private String routerConfigKey;
    private List<FlowNodeRouterInfo> router;

    public <T> FlowNode getNext(T flowData) {
        FlowNodeRouterEnum flowNodeRouterEnum = FlowNodeRouterEnum.getByKey(routerConfigKey);
        if (flowNodeRouterEnum == null) {
            flowNodeRouterEnum = FlowNodeRouterEnum.PICK_FIRST_ROUTER;
        }

        return flowNodeRouterEnum.router.pick(router, flowData);
    }
}
