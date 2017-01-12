package basic;

/**
 * 功能描述: 二分查找
 * https://zh.wikipedia.org/wiki/%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2%E7%AE%97%E6%B3%95
 * <p>
 * 1.查找的数组是有序的
 *
 * @Author chen.yiran
 * @Date 17/1/12.
 */
public class BinarySearch {

    // 重复造轮子
    // 递归实现
    public int binarySearchRecur(int[] arr, int tar, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int mid = begin + (end - begin) / 2;
        if (arr[mid] > tar) return binarySearchRecur(arr, tar, begin, mid - 1);
        else if (arr[mid] < tar) return binarySearchRecur(arr, tar, mid + 1, end);
        return mid;
    }

    public int binarySearchWhile(int[] arr, int tar) {
        int begin = 0;
        int end = arr.length - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;
            if (arr[mid] > tar) {
                end = mid - 1;
            } else if (arr[mid] < tar) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // jdk7中新增的Arrays.binarySearch()
    public static int binarySearch(int[] var0, int var1, int var2, int var3) {
        /** rangeCheck(var0.length, var1, var2); */
        return binarySearch0(var0, var1, var2, var3);
    }

    private static int binarySearch0(int[] arr, int begin, int end, int tar) {
        // 范围为前包后不包即[)
        int h = begin;
        int p = end - 1;

        while (h <= p) {
            // 移位运算符优先级低于+
            // >>> 无符号右移
            // 近似相当于 (h+p)/2
            int mid = h + p >>> 1;
            int var7 = arr[mid];
            if (var7 < tar) {
                h = mid + 1;
            } else {
                // mid 直接命中 target 即返回
                if (var7 <= tar) {
                    return mid;
                }

                p = mid - 1;
            }
        }
        // 返回 -(插入点+1) 负数为了表示未找到
        // This method returns index of the search key, if it is contained in the array,
        // else it returns (-(insertion point) - 1).
        // The insertion point is the point at which the key would be inserted into the array:
        // the index of the first element greater than the key,
        // or a.length if all elements in the array are less than the specified key.
        return -(h + 1);
    }

}
