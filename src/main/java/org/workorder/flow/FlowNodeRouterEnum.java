package org.workorder.flow;

public enum FlowNodeRouterEnum {
    PICK_FIRST_ROUTER("pick_first", new FirstFlowNodeRouter());

    FlowNodeRouterEnum(String key, FlowNodeRouter router) {
        this.key = key;
        this.router = router;
    }

    public String key;

    public FlowNodeRouter router;

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public static FlowNodeRouterEnum getByKey(String key) {
        for (FlowNodeRouterEnum item : FlowNodeRouterEnum.values()) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }
        return null;
    }
}
