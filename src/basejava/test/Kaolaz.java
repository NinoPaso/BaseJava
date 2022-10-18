package basejava.test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Kaolaz {
    private static final BigInteger BIG_1 = new BigInteger("1");
    private static final BigInteger BIG_2 = new BigInteger("2");
    private static final BigInteger BIG_3 = new BigInteger("3");
    private static final BigInteger BIG_5 = new BigInteger("5");


    public static void kaolaFun(BigInteger value){
        //1.判断奇数偶数2.进行公式计算
        while(1 == value.compareTo(BIG_1)) {
            if (value.mod(BIG_2).intValue() ==0) {
                value = value.divide(BIG_2);
            } else {
                value = value.multiply(BIG_3).add(BIG_1);
            }
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        BigInteger bi = new BigInteger("2");
        Kaolaz.kaolaFun(bi.pow(5000).add(BIG_3));
    }
}
