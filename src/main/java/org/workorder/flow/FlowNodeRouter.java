package org.workorder.flow;

import java.util.List;

public interface FlowNodeRouter {
    <T> FlowNode pick(List<FlowNodeRouterInfo> router, T flowData);
}
