package com.fish.base.type;

public class MainTest {

    /**
     * 测试基础数据类型转型
     *
     * 结论 位数多的类型转型为位数少的类型会抛弃多余的位数
     *
     * long 转 int 抛弃高32位  保留低32位
     * 这样转型结果很可能出错
     *
     * 0x80000000ffffffffL = 1000 0000 0000 0000 0000 0000 0000 0000 1111 1111 1111 1111 1111 1111 1111 1111
     * 8 = 1000
     * 最高位是符号位
     *
     * @param args
     */
    public static void main(String[] args) {
        long a = Long.MAX_VALUE;

        int b = (int) a;
//        9223372036854775807
//       -9223372032559808513
        a = 8223372036854775807L;
        a = 0x80000000ffffffffL;
        a = 0x8f000000ffffffffL;
        b = (int) a;
        long c = a & 0x80000000ffffffffL;
        System.out.println(b);
        System.out.println(c);


        long d = (long) Integer.MAX_VALUE;
        System.out.println(d);

        int e = Byte.MAX_VALUE;
        System.out.println(e);

        byte f = (byte) (e << 1);
        System.out.println(f);
    }
}
