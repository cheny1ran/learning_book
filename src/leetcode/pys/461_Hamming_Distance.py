# -*- coding: utf-8 -*-
'''
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
'''


class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        count = 0
        z = x ^ y
        bz = bin(z)
        for i in str(bz)[2:]:
          if i == '1':
            count += 1
        return count

if __name__ == '__main__':
  sol = Solution()
  print(sol.hammingDistance(1, 4))