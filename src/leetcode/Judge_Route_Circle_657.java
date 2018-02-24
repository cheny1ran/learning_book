package leetcode;

/**
 * 功能描述:
 *
 * @Author chen.yiran
 * @Date 17/8/13.
 */
public class Judge_Route_Circle_657 {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    x++;
                    continue;
                case 'L':
                    x--;
                    continue;
                case 'U':
                    y++;
                    continue;
                case 'D':
                    y--;
                    continue;
            }
        }
        return x == 0 && y == 0;
    }
}
