package cn.basejava.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankTest {

    public static void main(String[] args) {
        BigDecimal[] bigDecimals = {
                new BigDecimal(58),
                new BigDecimal(58),
                new BigDecimal(63),
                new BigDecimal(63),
                new BigDecimal(79),
                new BigDecimal(79)
        };
        List<BigDecimal> list = Arrays.asList(bigDecimals);
        List<Integer> integers = updateDataRank(list);
        System.out.println(integers);
    }

    public static  List<Integer> updateDataRank(List<BigDecimal> list) {
        // 返回的List
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            // 获取当前数据
            BigDecimal data = list.get(i);
            // 从第二个开始 比较对象等与前一个
            BigDecimal compareData = null;
            if (i>0) {
                compareData = list.get(i-1);
            }
            if (null != compareData) {
                if (compareData.compareTo(data) == 0) {
                    returnList.add(returnList.get(i-1));
                } else {
                    returnList.add(i+1);
                }
            } else {
                returnList.add(i+1);
            }
        }
        return returnList;
    }
}
