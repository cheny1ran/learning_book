package leetcode;

/**
 * 功能描述:
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 *
 * @Author chen.yiran
 * @Date 17/5/3.
 */
public class Diagonal_Traverse_498 {

    /**
     *  pos
     *  [0,0],[0,1],[1,0],[2,0],[1,1],[0,2],[1,2],[2,1],[2,2]
     *
     *  if
     *  [ 1, 2, 3, 4 ],
     *  [ 5, 6, 7, 8 ],
     *  [ 9, 10, 11, 12 ]
     *
     *  [1,2,5,9,6,3,4,7,10,11,8,12]
     *
     *
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ],
     *  [ 10, 11, 12]
     *
     *  [1,2,4,7,5,3,6,8,19,11,9,12]
     *
     *  flag means up->down or down->up
     *
     *  if flag:
     *      if x+1, y in range:
     *          beginX = x+1, beginY = y
     *      else:
     *          beginX = x,beginY = y+1
     *      list.add(beginX,beginY)
     *      beginX -= 1,beginY += 1
     *      while beginX,beginY in range:
     *          list.add(beginX,beginY)
     *      flag=!flag
     *  if !flag:
     *      if x, y+1 in range:
     *          beginX = x, beginY = y+1
     *      else:
     *          beginX = x+1,beginY = y
     *      beginX = x+1, beginY = y
     *      list.add(beginX,beginY)
     *      beginX -= 1,beginY += 1
     *      while beginX,beginY in range:
     *          list.add(beginX,beginY)
     *      flag=!flag
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int x = 0, y = 0;
        boolean flag = true;

        int[] ans = new int[matrix.length * matrix[0].length];
        int i = 0;
        ans[i++] = matrix[x][y];

        while (x < matrix.length && y < matrix[0].length) {
            if (!flag) {
                if (x + 1 < matrix.length) {
                    x += 1;
                } else if (y + 1 < matrix[0].length) {
                    y += 1;
                } else break;
                ans[i++] = matrix[x][y];
                while (x - 1 >= 0 && y + 1 < matrix[0].length) {
                    x -= 1;
                    y += 1;
                    ans[i++] = matrix[x][y];
                }
            } else {
                if (y + 1 < matrix[0].length) {
                    y += 1;
                } else if (x + 1 < matrix.length) {
                    x += 1;
                } else break;
                ans[i++] = matrix[x][y];
                while (x + 1 < matrix.length && y - 1 >= 0) {
                    x += 1;
                    y -= 1;
                    ans[i++] = matrix[x][y];
                }
            }
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[] ans = new Diagonal_Traverse_498().findDiagonalOrder(matrix);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }


}
