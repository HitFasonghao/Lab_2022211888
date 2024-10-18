import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 *测试用例设计的总体原则
 * 等价类划分法：
 * 将输入数据划分为几个等价类，每个类中的任何一个数据都可以代表整个类的行为。
 * 对于本例，将输入矩阵划分为“全是水”、“全是陆地”、“混合情况”这三种类别。
 * 边界值分析法：
 * 测试输入范围的边界值，因为程序在边界条件下的行为经常会出现错误。
 * 对于本例，考虑矩阵的尺寸边界情况，如最小尺寸 空矩阵 和最大尺寸 300x300。
 */
class L2022211888_8_Test {

    @Test
    public void testWaterGrid(){
        //测试目的：验证当输入为全0的矩阵时，函数返回0。
        //测试用例：[[0,0],[0,0]]
        char[][] grid ={{'0','0'},{'0','0'}};
        Solution8 solution8 = new Solution8();
        assertEquals(0,solution8.numIslands(grid));
    }

    @Test
    public void testLandGrid(){
        //测试目的：验证当输入为全1的矩阵时，函数返回1
        //测试用例：[[1,1],[1,1]]
        char[][] grid ={{'1','1'},{'1','1'}};
        Solution8 solution8 =new Solution8();
        assertEquals(1,solution8.numIslands(grid));
    }

    @Test
    public void testMixGrid(){
        //测试目的：验证当输入有多个不相临的1的矩阵时，函数能够正确返回岛屿个数
        //测试用例：[[1,0,1,1],[0,1,1,0],[0,1,0,0],[1,1,0,1]]
        char[][] grid ={
                {'1','0','1','1'},
                {'0','1','1','0'},
                {'0','1','0','0'},
                {'1','1','0','1'}
        };
        Solution8 solution8 = new Solution8();
        assertEquals(3,solution8.numIslands(grid));
    }

    @Test
    public void testEmptyGrid() {
        //测试目的：验证当输入为null或空矩阵时，函数返回0。
        //测试用例：空矩阵
        char[][] grid ={};
        Solution8 solution8=new Solution8();
        assertEquals(0,solution8.numIslands(grid));
    }

    @Test
    public void testLargeGrid(){
        //测试目的：验证当输入巨大矩阵时，函数返回正确岛屿个数
        //测试用例：[0,0,0....,0]...[0,0....,1,0....,0]...[0,0,0....,0]
        char[][] grid = new char[300][300];
        for(int i = 0 ; i<300 ; i++){
            Arrays.fill(grid[i], '0');
        }
        grid[102][102]='1';
        Solution8 solution8 = new Solution8();
        assertEquals(1,solution8.numIslands(grid));
    }
}