//          9 is the player ------>@ in the map
//          8 is the monster ----->M in the map
//          7 is the npc --------->$ in the map



package rpg;

import java.util.Random;
import java.util.Scanner;

public class MovementCreature {

    
    
    public static void main(String[] args)
    {  
    }
    
    
    public MovementCreature(){
        
    }
    
    public MovementCreature(int[][] creature,int sizeofmap){
        spawnPlayer(creature,sizeofmap);
        spawnMonster(creature,sizeofmap);
        spawnNPC(creature,sizeofmap);
    }
    
     public void showmapMC(int[][] creature,int sizeofmap)
    {
//        int y;
//        int x;
        for(int y=0;y<sizeofmap;y++)
        {
            for(int x=0;x<sizeofmap;x++)
            {
                if(creature[y][x]==9)
                    System.out.print("@ ");
                else if(creature[y][x]==8)
                    System.out.print("M ");
                else if(creature[y][x]==7)
                    System.out.print("$ ");
                else
                    System.out.print("H ");
            }
            System.out.println("");
        }
    }
    
    public int[][] spawnPlayer(int[][] creature,int sizeofmap)
    {
        int x,y;
        Random rgen = new Random();
        x=rgen.nextInt(sizeofmap);
        y=rgen.nextInt(sizeofmap);
        creature[y][x]=9;//player
        return creature;
    }
    
    public int[][] Movement(char a,int sizeofmap,int[][] creature)
    {
        int count=0;
        int x=0;
        int y=0;
        int hold;
        switch(a)
        {
            case 'w':                                                           //up you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==9)                                   //player or nah
                        {
                            y--;
                            if(y<0||creature[y][x]==8||creature[y][x]==7)       //if out of bound/if monster/if npc
                                y++;                                            
                            else
                            {
                                y++;
                                hold=creature[y-1][x];                          //switch
                                creature[y-1][x]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 's'://down you go
                
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==9&&count==0)
                        {
                            count++;
                            y++;
                            if(y>=sizeofmap||creature[y][x]==8||creature[y][x]==7)
                                y--;
                            else
                            {
                                y--;
                                hold=creature[y+1][x];
                                creature[y+1][x]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 'a'://left you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==9)
                        {
                            x--;
                            if(x<0||creature[y][x]==8||creature[y][x]==7)
                                x++;
                            else
                            {
                                x++;
                                hold=creature[y][x-1];
                                creature[y][x-1]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 'd'://right you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==9&&count==0)
                        {
                            count++;
                            x++;
                            if(x>=sizeofmap||creature[y][x]==8||creature[y][x]==7)
                                x--;
                            else
                            {
                                x--;
                                hold=creature[y][x+1];
                                creature[y][x+1]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
        }
        return creature;
    }
    
    
    public int[][] spawnMonster(int[][] creature,int sizeofmap)
    {
        sizeofmap-=1;
        Random rgen = new Random();
        int y_spawn;
        int x_spawn;
        int x_player=0;
        int y_player=0;
        int num;        
        num=rgen.nextInt(3);

        for(int y=0;y<sizeofmap;y++)
            for(int x=0;x<sizeofmap;x++)
                if(creature[y][x]==9)
                {
                    x_player=x;
                    y_player=y;      
                }
        if(x_player<sizeofmap/2)
            x_spawn=sizeofmap-num;
        else
            x_spawn=num;
        
        if(y_player<sizeofmap/2)
            y_spawn=sizeofmap-num;
        else
            y_spawn=num;
        
        creature[y_spawn][x_spawn]=8;
        return creature;
    }
   
    
    public int[][] moveMonster(int[][] creature,int sizeofmap)
    {
        int count=0;
        int x=0;
        int y=0;
        int hold;
        Random rgen = new Random();
        int a=rgen.nextInt(4);
        switch(a)
        {
            case 0://up you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==8)
                        {
                            y--;
                            if(y<0||creature[y][x]==9||creature[y][x]==7)
                                y++;
                            else
                            {
                                y++;
                                hold=creature[y-1][x];
                                creature[y-1][x]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 1://down you go
                
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==8&&count==0)
                        {
                            count++;
                            y++;
                            if(y>=sizeofmap||creature[y][x]==9||creature[y][x]==7)
                                y--;
                            else
                            {
                                y--;
                                hold=creature[y+1][x];
                                creature[y+1][x]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 2://left you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==8)
                        {
                            x--;
                            if(x<0||creature[y][x]==9||creature[y][x]==7)
                                x++;
                            else
                            {
                                x++;
                                hold=creature[y][x-1];
                                creature[y][x-1]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
            case 3://right you go
                for(y=0;y<sizeofmap;y++)
                {
                    for(x=0;x<sizeofmap;x++)
                    {
                        if(creature[y][x]==8&&count==0)
                        {
                            count++;
                            x++;
                            if(x>=sizeofmap||creature[y][x]==9||creature[y][x]==7)
                                x--;
                            else
                            {
                                x--;
                                hold=creature[y][x+1];
                                creature[y][x+1]=creature[y][x];
                                creature[y][x]=hold;
                            }
                        }
                    }
                }
                 break;
                 
        }
        return creature;
    }
    
    public boolean checkMonster(int creature[][],int sizeofmap)
    {
        for(int i=0;i<sizeofmap;i++)
        {
            for(int j=0;j<sizeofmap;j++)
            {
                if(creature[i][j]==8)                                       //find location of monster
                {
                   return true;                                             //if monster is alive true
                }
            }
        }
        return false;                                                       //if monster is ded false
    }
    
    
    public int[][] spawnNPC(int[][] creature,int sizeofmap)
    {
        int x,y;
        Random rgen = new Random();
        x=rgen.nextInt(sizeofmap);
        y=rgen.nextInt(sizeofmap);
        
        while(creature[x][y]!=0)    //if overlap with npc/player
        {
        x=rgen.nextInt(sizeofmap);
        y=rgen.nextInt(sizeofmap);
        }
        creature[y][x]=7;//player
        return creature;
    }
    
    public boolean confirmInteraction(int[][] creature,int sizeofmap,int what)  //make sure there's npc/monster to interact
    {
        //find location of player first
            int x=0,y=0;
            for(int i=0;i<sizeofmap;i++)
            {
                for(int j=0;j<sizeofmap;j++)
                {
                    if(creature[i][j]==9)                                       //find location of player
                    {
                        y=i;
                        x=j;
                    }
                }
            }
            
            
            //top left
            if(x==0&&y==0)
            {
                if(creature[y+1][x]==what||creature[y][x+1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //top right
            else if(x==(sizeofmap-1)&&y==0)
            {
                if(creature[y+1][x]==what||creature[y][x-1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //bottom left
            else if(x==0&&y==(sizeofmap-1))
            {
                if(creature[y-1][x]==what||creature[y][x+1]==what)
                {
                    System.out.println("---------------------------bottom-left-[true]-----------------------------");
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //bottom right
            else if(x==(sizeofmap-1)&&y==(sizeofmap-1))
            {
                if(creature[y-1][x]==what||creature[y][x-1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            
            
            //on the left side of the wall
            else if(x==0)
            {
                if(creature[y-1][x]==what||creature[y+1][x]==what||creature[y][x+1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //on the right side of the wall
            else if(x==(sizeofmap-1))
            {
                if(creature[y-1][x]==what||creature[y+1][x]==what||creature[y][x-1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //on the top
            else if(y==0)
            {
                if(creature[y+1][x]==what||creature[y][x-1]==what||creature[y][x+1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }
            
            //bottom
            else if(y==(sizeofmap-1))
            {
                if(creature[y-1][x]==what||creature[y][x-1]==what||creature[y][x+1]==what)
                {
                    return true;                                                    
                }
                else
                {
                    return false;                                                    
                }
            }            
            
            //middle
            else
            {
                if(creature[y-1][x]==what||creature[y+1][x]==what||creature[y][x-1]==what||creature[y][x+1]==what)
                {
                    return true;                                                    //yes there is __ nearby
                }
                else
                {
                    return false;                                                   //nah nobody is there
                }
            }
        
    }
    
}


  
