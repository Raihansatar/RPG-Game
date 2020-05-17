package rpg;
public class Combine 
{
    public Combine(){
        
    }
    public int[][] ShowAll(int map[][],int creature[][],int SizeOfMap)
    {
        int mwp[][]=new int[SizeOfMap][SizeOfMap];
        for(int i=0;i<SizeOfMap;i++)
        {
            for(int j=0;j<SizeOfMap;j++)
            {
                if(creature[i][j]==9)//player
                    System.out.print("@ ");
                else if(creature[i][j]==8)//monster
                    System.out.print("M ");
                else if (creature[i][j]==7)//npc
                    System.out.print("$ ");
                else
                {
                    if(map[i][j]==1)
                        System.out.print("~ ");//water
                    else if(map[i][j]==2)
                        System.out.print(": ");//sand
                    else
                        System.out.print("\" ");//grass
                            
                }
            }
            System.out.println("");
        }
        return mwp;
    }
    
    
}
