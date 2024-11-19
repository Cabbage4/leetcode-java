package org.workorder.flow;

import java.util.List;
import java.util.Objects;

public class FirstFlowNodeRouter implements FlowNodeRouter {
    @Override
    public <T> FlowNode pick(List<FlowNodeRouterInfo> router, T flowData) {
        if (Objects.isNull(router) || router.size() == 0) {
            return null;
        }
        return router.get(0).getFlowNode();
    }
}
