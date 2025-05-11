package Recursion;

import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

class Solution {

    boolean issafe(int[][] maze, int[][] visited, int x, int y) {
        if ((x >= 0 && x < maze[0].length) && (y >= 0 && y < maze.length) && (visited[y][x] == 0) && (maze[y][x] == 1))
            return true;
        else
            return false;
    }

    void solve(int[][] maze, int[][] visited, ArrayList<String> arrayList, StringBuilder str, int x, int y) {
        if (y == maze.length - 1 && x == maze[0].length - 1) {
            String ll = new String(str);

            arrayList.add(ll);
            return;
        }

        visited[y][x] = 1;

        // left
        if (issafe(maze, visited, x - 1, y)) {
            str.append("L");
            solve(maze, visited, arrayList, str, x - 1, y);
            str.deleteCharAt(str.length() - 1);
        }

        // right
        if (issafe(maze, visited, x + 1, y)) {
            str.append("R");
            solve(maze, visited, arrayList, str, x + 1, y);
            str.deleteCharAt(str.length() - 1);
        }
        // up
        if (issafe(maze, visited, x, y - 1)) {
            str.append("U");
            solve(maze, visited, arrayList, str, x, y - 1);
            str.deleteCharAt(str.length() - 1);
        }
        // down
        if (issafe(maze, visited, x, y + 1)) {
            str.append("D");
            solve(maze, visited, arrayList, str, x, y + 1);
            str.deleteCharAt(str.length() - 1);
        }

        visited[y][x] = 0;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> arrayList = new ArrayList<>();

        if (maze == null || maze.length == 0 || maze[0].length == 0 || maze[0][0] == 0)
            return arrayList;

        int[][] visited = new int[maze.length][maze[0].length];

        StringBuilder str = new StringBuilder();

        solve(maze, visited, arrayList, str, 0, 0);

        Collections.sort(arrayList);

        return arrayList;

    }
}