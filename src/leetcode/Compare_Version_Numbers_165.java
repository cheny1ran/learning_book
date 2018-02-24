package leetcode;

/**
 * 功能描述:
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Here is an example of version numbers ordering:
 * <p>
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * @Author chen.yiran
 * @Date 17/6/29.
 */
public class Compare_Version_Numbers_165 {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        String[] lo = (v1.length < v2.length) ? v2 : v1;
        String[] sh = (v1.length < v2.length) ? v1 : v2;
        for (int i = 0; i < sh.length; i++) {
            int i1 = Integer.parseInt(v1[i]);
            int i2 = Integer.parseInt(v2[i]);
            if (i1 == i2) continue;
            if (i1 < i2) return -1;
            else return 1;
        }
        for (int i = sh.length; i < lo.length; i++) {
            int i1 = Integer.parseInt(lo[i]);
            if (i1 == 0) continue;
            return lo == v1 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Compare_Version_Numbers_165().compareVersion("1.01", "1"));
    }

}
