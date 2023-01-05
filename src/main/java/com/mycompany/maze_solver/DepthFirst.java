/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.List;

/**
 *
 * @author jaivi
 */
public class DepthFirst {
    public static boolean searchpath(int[][] maze, int x, int y, List<Integer>path){
        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x] == 0){
            maze[y][x] = 2;
            // possibilities
            //left
            int dx = -1;
            int dy = 0;
            if(searchpath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 1;
            dy = 0;
            if(searchpath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = -1;
            if(searchpath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            dx = 0;
            dy = 1;
            if(searchpath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
        }
        return false;
    }
}
