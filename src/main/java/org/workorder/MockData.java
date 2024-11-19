package org.workorder;

import java.util.HashMap;
import java.util.Map;

import org.workorder.flow.FlowConfig;

public class MockData {
    private static Map<String, String> mp = new HashMap<>();

    private static String modelOnline = "{\n" + //
                "    \"flowNode\": {\n" + //
                "        \"routerConfigKey\": \"pick_first\",\n" + //
                "        \"router\": [\n" + //
                "            {\n" + //
                "                \"flowNode\": {\n" + //
                "                    \"routerConfigKey\": \"pick_first\",\n" + //
                "                    \"router\": [\n" + //
                "                        {\n" + //
                "                            \"flowNode\": {}\n" + //
                "                        }\n" + //
                "                    ]\n" + //
                "                }\n" + //
                "            }\n" + //
                "        ]\n" + //
                "    }\n" + //
                "}";

    static {
        mp.put("model_online", modelOnline);
    }

    public static FlowConfig get(String key) {
        FlowConfig r = FlowConfig.buildFromJson(mp.get(key));
        r.resetFlowNodeId();
        return r;
    }
}
