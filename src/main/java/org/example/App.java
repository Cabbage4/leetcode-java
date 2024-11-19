package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.workorder.WorkOrder;

public class App {
    public static void main(String[] args) {
        WorkOrder workOrder = WorkOrder.build("model_online");
        workOrder.approve();
        System.out.println(workOrder.state);
        workOrder.approve();
        System.out.println(workOrder.state);
        workOrder.approve();
        System.out.println(workOrder.state);
    }
}

