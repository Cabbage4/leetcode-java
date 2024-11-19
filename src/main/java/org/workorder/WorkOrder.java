package org.workorder;

import java.util.Objects;

import org.workorder.flow.FlowConfig;
import org.workorder.flow.FlowNode;

public class WorkOrder {
    public FlowConfig flowConfig;

    public Integer currentFlowNodeId;

    public String state = "pedding";

    public static WorkOrder build(String key) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.flowConfig = MockData.get( key);
        workOrder.currentFlowNodeId = 0;
        return workOrder;
    }

    public void approve() {
        FlowNode flowNode = flowConfig.getFlowNode(currentFlowNodeId);
        FlowNode nextFlowNode = flowNode.getNext("a data");

        if (Objects.isNull(nextFlowNode)) {
            state = "pass";
            return;
        }
        currentFlowNodeId = nextFlowNode.getId();
    }

    public void reject() {
        state = "reject";
    }
}


