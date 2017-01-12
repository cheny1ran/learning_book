package basic;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/1/12.
 */
public class BitShifts {

    /**
     * 移位运算符的优先级低于+/-
     */

    public static void main(String[] args) {
        System.out.println("-16 二进制 : " + Integer.toBinaryString(-16));

        // 按二进制形式把所有的数字向左移动对应的位数 高位移出(舍弃) 低位补0
        System.out.println("-16 << 1 = " + (-16 << 1));
        System.out.println("-16 << 1 二进制 : " + Integer.toBinaryString(-16 << 1));
        // 按二进制形式把所有的数字向右移动对应的位数 低位移出(舍弃) 高位的空位补符号位 即正数补0 负数补1
        System.out.println("-16 >> 1 = " + (-16 >> 1));
        System.out.println("-16 >> 1 二进制 : " + Integer.toBinaryString(-16 >> 1));
        // 无符号右移运算符>>> 忽略了符号位扩展，0补最高位
        System.out.println("-16 >>> 1 = " + (-16 >>> 1));
        System.out.println("-16 >>> 1 二进制 : " + Integer.toBinaryString(-16 >>> 1));
    }
}
