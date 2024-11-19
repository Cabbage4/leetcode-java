package org.workorder.flow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;

import lombok.Data;

@Data
public class FlowConfig {
    private FlowNode flowNode;

    @JSONField(serialize = false)
    private Map<Integer, FlowNode> flowNodeMap = new HashMap<>();

    public static FlowConfig buildFromJson(String str) {
        FlowConfig flowConfig = JSONObject.parseObject(str, FlowConfig.class);
        dfsFlowNode(flowConfig.flowNode, flowNode -> {
            flowConfig.flowNodeMap.put(flowConfig.flowNode.getId(), flowNode);
        });
        return flowConfig;
    }

    public String toJsonString() {
        return JSONObject.toJSONString(this);
    }

    public FlowNode getFlowNode(Integer id) {
        return flowNodeMap.get(id);
    }

    public void resetFlowNodeId() {
        final int[] num = {0};
        dfsFlowNode(flowNode, flowNode -> {
            flowNode.setId(num[0]);
            flowNodeMap.put(flowNode.getId(), flowNode);
            num[0]++;
        });
    }

    private static void dfsFlowNode(FlowNode flowNode, Consumer<FlowNode> f) {
        if (Objects.isNull(flowNode)) {
            return;
        }

        f.accept(flowNode);

        if (flowNode.getRouter() == null) {
            return;
        }

        flowNode.getRouter().forEach(item -> {
            dfsFlowNode(item.getFlowNode(), f);
        });
    }
}
