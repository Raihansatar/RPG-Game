package rpg;
import java.util.Random;
public class GenerateMapBig {

    
    
    /////////////////////////SHOW MAP///////////////////////////
    //                                                        //
    //       only show the map(no player/npc/monster)         //
    //                                                        //
    ////////////////////////////////////////////////////////////
    
    public void show(int map[][])
    {

        for (int i=0; i<map.length;i++) {
            for (int j = 0; j<map.length; j++) {
                if(map[i][j]==1)   
                    System.out.print("~ ");
                else if(map[i][j]==2)
                    System.out.print(": ");
                else if(map[i][j]==3)
                    System.out.print("o ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }  
    
    
    
    
    //////////////////////Terrain placement/////////////////////
    //                                                        //
    //                        1 - water                       //
    //                        2 - sand                        //
    //                        3 - rocks                       //
    //                       -1 - grass                       //
    //                      returns array                     //
    //                                                        //
    //accept size 0f terrain,type of terrrain, array to modify//
    ////////////////////////////////////////////////////////////
    
    public int[][] placeterrain(int place[][],int SizeOfMap,int SizeOfTerrain,String TypeOfTerrain)
    {
        Random rgen = new Random();
        
        SizeOfTerrain = (SizeOfTerrain*(SizeOfMap*SizeOfMap))/100;                          //find percentage of map coverage
        int i = rgen.nextInt(SizeOfMap);                                                    //pick first location to start generate terrain
        int j = rgen.nextInt(SizeOfMap);
        
        int Terrain=TerrainNumber(TypeOfTerrain);                                           //give terrain its own number, e.g "water" is 1
        place[i][j]=Terrain;                                                                //start
        SizeOfTerrain--;
        
        int move;                                                                           //next placement movement
        boolean placement;
        int rcount=0;
                
        for(int count=1;count<=SizeOfTerrain;count++)                                      //loop until all is placed
        {
            placement=false;
            while(placement==false)                                                         //if not placed, it dosent count
            {
                if(rcount%2==0)
                move = rgen.nextInt(8)+1;
                   else if(rcount%6==0)
                       move = rgen.nextInt(4)+1+8;
                         else
                            move = rgen.nextInt(4)+1;
                    
                
///////////////////////////////////////////////////START OF SWITCH//////////////////////////////////////////////////////////////////
                switch(move)                                                                //pick the direction of the placement
                {
//////////////////////////////////////////////////place at AWDS////////////////////////////////////////////////////
                    case 1: j++;
                            if(j>=SizeOfMap||place[i][j]==Terrain)                          ////////move right
                            {   j--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j--;
                                break;
                            }
                            
                    case 2: j--;
                            if(j<0||place[i][j]==Terrain)                                   /////////move left
                            {
                                j++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j++;
                                break;
                            }
                            
                    case 3: i++;
                            if(i>=SizeOfMap||place[i][j]==Terrain)                          /////////move down
                            {
                                i--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                i--;
                                break;
                            }
                            
                            
                    case 4: i--;
                            if(i<0||place[i][j]==Terrain)                                   /////////move up
                            {
                                i++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                i++;
                                break;
                            }       
                            
//////////////////////////////////////////move to corner and place///////////////////////////////////////////////////
                            
                    case 5: j++;
                            i--;
                            if(i<0||j>=SizeOfMap||place[i][j]==Terrain)                          ////////move top right
                            { 
                                j--;
                                i++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                break;
                            }
                    case 6: j--;
                            i--;
                            if(i<0||j<0||place[i][j]==Terrain)                          ////////move top left
                            {   
                                j++;
                                i++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                break;
                            }
                            
                    case 7: j++;
                            i++;
                            if(i>=SizeOfMap||j>=SizeOfMap||place[i][j]==Terrain)         ////////move bottom right
                            {  
                                j--;
                                i--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                break;
                            }
                    case 8: j--;
                            i++;
                            if(i>=SizeOfMap||j<0||place[i][j]==Terrain)                   ////////move bottom left
                            {   
                                j++;
                                i--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                break;
                            }
/////////////////////////////////////////////////////place at corner/////////////////////////////////////////////////////////////
                    case 9: j++;
                            i--;
                            if(i<0||j>=SizeOfMap||place[i][j]==Terrain)                          ////////move top right
                            { 
                                j--;
                                i++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j--;
                                i++;
                                break;
                            }
                    case 10: j--;
                            i--;
                            if(i<0||j<0||place[i][j]==Terrain)                          ////////move top left
                            {   
                                j++;
                                i++;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j++;
                                i++;
                                break;
                            }
                            
                    case 11: j++;
                            i++;
                            if(i>=SizeOfMap||j>=SizeOfMap||place[i][j]==Terrain)         ////////move bottom right
                            {  
                                j--;
                                i--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j--;
                                i--;
                                break;
                            }
                    case 12: j--;
                            i++;
                            if(i>=SizeOfMap||j<0||place[i][j]==Terrain)                   ////////move bottom left
                            {   
                                j++;
                                i--;
                                break;
                            }
                            else
                            {
                                place[i][j]=Terrain;
                                placement=true;
                                j++;
                                i--;
                                break;
                            }         
                            
                }
////////////////////////////////////////////////////END OF SWITCH//////////////////////////////////////////////////////////////////



                rcount++;
                if(rcount==5000)                        //if the palcement is closed off(no where to go, pick a new place to start)
                {
                    while(place[i][j]==Terrain)
                    {
                        i = rgen.nextInt(SizeOfMap);
                        j = rgen.nextInt(SizeOfMap);
                    }
                    place[i][j]=Terrain;
                    placement=true;
                    rcount=0;
                }          
            }                                        //all terrain spot have been placed.       
        }        
        return place;
    }
    
    
    
    
    
    
    
    
    
    
    /////////////////Terrain placement SCATTERED////////////////
    //                                                        //
    //                        1 - water                       //
    //                        2 - sand                        //
    //                        3 - rocks                       //
    //                       -1 - grass                       //
    //                      returns array                     //
    //                                                        //
    //accept size 0f terrain,type of terrrain, array to modify//
    ////////////////////////////////////////////////////////////
    
    public int[][] placeterrainScatter(int map[][],int SizeOfTerrain,String TypeOfTerrain)   //for scattered terrain like rocks
    {
        Random rgen = new Random();
        int SizeOfMap=map.length;
        SizeOfTerrain = (SizeOfTerrain*(SizeOfMap*SizeOfMap))/100;                           //find percentage of map coverage
        int Terrain = TerrainNumber(TypeOfTerrain);
        
        while(SizeOfTerrain>0)
        {
            int i = rgen.nextInt(SizeOfMap);                                                 //pick location
            int j = rgen.nextInt(SizeOfMap);
            map[i][j]=Terrain;
            SizeOfTerrain--;
        }
        return map;
    }
    
    
    
    
    private static int TerrainNumber(String type)                                               //giVe the terrain an integer value
    {
        int num;
        
        if(type.equalsIgnoreCase("water"))
            num=1;
        else if(type.equalsIgnoreCase("sand"))
            num=2;
        else if(type.equalsIgnoreCase("rocks"))
            num=3;
        else
            num=-1;
        return num;
    }
    
}//end
