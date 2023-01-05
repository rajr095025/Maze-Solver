/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author jaivi
 */
public class MazeSolver extends JFrame{
    int [] [] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,1,1,0,0,1,1,1,1,1,1},
        {1,0,1,1,1,0,1,1,0,0,0,0,1},
        {1,0,0,0,0,0,1,1,0,1,1,0,1},
        {1,1,1,0,1,1,1,1,0,1,1,0,1},
        {1,1,1,0,1,1,1,1,0,1,1,0,1},
        {1,1,1,0,1,0,0,0,0,1,1,0,1},
        {1,1,0,0,1,0,1,1,1,1,1,0,1},
        {1,0,0,1,1,0,0,1,1,0,0,0,1},
        {1,0,1,1,1,1,0,1,1,0,1,1,1},
        {1,0,0,0,0,0,0,1,1,0,0,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    public List<Integer> path = new ArrayList <> ();
    
    public MazeSolver (){
        setTitle("Maze Solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze, 1, 1, path);
        System.out.println(path);
    }
    @Override 
    public void paint(Graphics g){
        // placing graphics g with dimension required inside java frame
        g.translate(125, 60);
        super.paint(g);
        // accessing matrix elements and setting colors to each element
        for(int i=0; i<maze.length; i++){
            for(int j = 0; j< maze[0].length; j++){
                // Color class to import colors
                Color color;
                // setting particular color to particular element
                switch(maze[i][j]){
                    case 1: color = Color.BLACK; break;
                    case 9: color = Color.RED; break;
                    default: color = Color.WHITE; break;
                }
                // setting  graphics g color to the selected color
                g.setColor(color);
                // with the color selected , filling the paint as a rectangular shape for given dimensions 
                g.fillRect(30*j,30*i, 30, 30);
                // again setting color to graphics g because we need different col0r for border
                g.setColor(Color.red);
                // drawing border for the whole maze in rectangle shape with selected color
                g.drawRect(30*j,30*i,30,30);
            }
            
        }
        
        for(int i=0; i<path.size(); i += 2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);
            System.out.println("X "+pathx+" Y "+pathy);
            g.setColor(Color.green);
            g.fillRect(30*pathx, 30*pathy, 30,30 );
            
        }
    }

    public static void main(String [] args){
        MazeSolver view = new MazeSolver();
        view.setVisible(true);
    }
}
