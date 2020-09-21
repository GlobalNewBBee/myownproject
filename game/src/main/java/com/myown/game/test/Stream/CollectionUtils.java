package com.myown.game.test.Stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {

    public static Collection getCollection(){
        ArrayList list = new ArrayList();
        list.add(new Employee(1001,"马云",45,4563));
        list.add(new Employee(1002,"马化腾",27,6863.28));
        list.add(new Employee(1003,"雷军",19,2584.78));
        list.add(new Employee(1004,"刘强东",36,6715.48));
        list.add(new Employee(1005,"任正非",60,9543.78));
        return list;
    }
}
