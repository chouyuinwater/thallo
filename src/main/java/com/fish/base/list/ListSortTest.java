package com.fish.base.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ListSortTest {
    public void sort_1() {

        List<ListBean> listBeans = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            ListBean listBean = new ListBean();
            listBean.setId((long) new Random().nextInt()%10);
            listBean.setCode(null);
            listBean.setValue((double) new Random().nextInt()%10);
            listBean.setPrice(new BigDecimal(new Random().nextInt()%10));

            switch (i) {
                case 1:
                    listBean.setName("A");
                case 2:
                    listBean.setName("B");
                case 3:
                    listBean.setName("C");
                case 4:
                    listBean.setName("D");
                case 5:
                    listBean.setName("E");
            }


            listBeans.add(listBean);
        }
        System.out.println(listBeans);
        listBeans.sort(Comparator.comparingInt(ListBean::getCode));
        System.out.println(listBeans);
        listBeans.sort(Comparator.comparingDouble(ListBean::getValue));
        System.out.println(listBeans);
        listBeans.sort(Comparator.comparingLong(ListBean::getId));
        System.out.println(listBeans);

        // 设置排序顺序为倒序
        Comparator<ListBean> routingComparator = Comparator.comparing(o -> -o.getCode());
        listBeans.sort(routingComparator);

    }

    public void sort_2() {
        List<ListBean> listBeans = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            ListBean listBean = new ListBean();
            listBean.setId((long) new Random().nextInt()%10);
            listBean.setCode(new Random().nextInt()%10);
            listBean.setValue((double) new Random().nextInt()%10);
            listBean.setPrice(new BigDecimal(new Random().nextInt()%10));

            switch (i) {
                case 1:
                    listBean.setName("A");
                case 2:
                    listBean.setName("B");
                case 3:
                    listBean.setName("C");
                case 4:
                    listBean.setName("D");
                case 5:
                    listBean.setName("E");
            }
            listBeans.add(listBean);
        }
        System.out.println(listBeans);
        listBeans.sort(Comparator.comparing(o -> -o.getId()));
        System.out.println(listBeans);
    }
}
