
package rpg;

import java.util.Random;
import java.util.Scanner;

public class RPGWorld {
    
    public static void main(String[] arg)
    {
        Combat player = new Combat();
        Combat enemy = new Combat();
        Shop shop = new Shop();
        print print = new print();
        Combine combo = new Combine();
         RandomMessage rmessage = new RandomMessage();
        print.Welco();
        System.out.println("Legend:");
        System.out.println("@ = player");
        System.out.println("$ = NPC");
        System.out.println("M = enemy");
        System.out.println("");
        System.out.println("Enemy: Press 'e' for combat");
        System.out.println("NPC: Press 'q' for shop, 'r' to talk");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        player.setHealth(100);
        player.setDamage(50);
        
        int sizeofmap = 50;
        int creature[][] =new int[sizeofmap][sizeofmap];
        int map[][] =new int[sizeofmap][sizeofmap];
        int show[][] =new int[sizeofmap][sizeofmap];
        char k;
        
        MovementCreature mc = new MovementCreature(creature,sizeofmap); 
        System.out.println("");
        
        GenerateMapBig Gmap = new GenerateMapBig();
        map=Gmap.placeterrain(map, sizeofmap, 20, "water");
        map=Gmap.placeterrain(map, sizeofmap, 5,"sand");

        System.out.println("");
        
        int count=0;
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
            System.out.println("Player Health: "+ player.getHealth());
            System.out.println("Player Damage: " + player.getDamage());
            System.out.println("Tamriel      : " + shop.getMoney());
            System.out.println("");

        show=combo.ShowAll(map, creature, sizeofmap);
        while(true)
        {
            System.out.print("Next move: ");
            k=scan.nextLine().charAt(0);
            System.out.println("");
            System.out.println("Player Health: "+ player.getHealth());
            System.out.println("Player Damage: " + player.getDamage());
            System.out.println("Tamriel      : " + shop.getMoney());
            System.out.println("");
            
            mc.Movement(k, sizeofmap, creature);
                       
            
            if(k=='r')
            {
                if(mc.confirmInteraction(creature, sizeofmap, 7)==true)
                {
                    rmessage.Message_Civilian_NPC();
                    System.out.println("");
                }
                System.out.println("");
            System.out.println("Player Health: "+ player.getHealth());
            System.out.println("Player Damage: " + player.getDamage());
            System.out.println("Tamriel      : " + shop.getMoney());
            System.out.println("");
            }
            
            if(k=='e')
            {
                
                if(mc.confirmInteraction(creature, sizeofmap, 8)==true)
                {
                    System.out.println("---------------------------BATTLE---------------------------");
                    System.out.println("");
                    System.out.println("");
                    print.MicScream();
                    System.out.println("");
                    
                    startCombat(creature, sizeofmap, player.getDamage(),  player , enemy );
                    
                    if(mc.checkMonster(creature, sizeofmap)==false)  //check if monster dies
                    {
                        int randnum = rand.nextInt(20);
                        shop.setMoney(shop.getMoney()+ randnum);
                        System.out.println("Enemy dropped " + randnum+ " tamriel"); // player money + 20
                        
                    }
                    System.out.println("----------------------------<===>---------------------------");
                    System.out.println("");
            System.out.println("Player Health: "+ player.getHealth());
            System.out.println("Player Damage: " + player.getDamage());
            System.out.println("Tamriel      : " + shop.getMoney());
            System.out.println("");
                }
                
            }
            
            if(k=='q')
            {
                
                if(mc.confirmInteraction(creature, sizeofmap, 7)==true)
                {
                System.out.println("---------------------------SHOP---------------------------");
                System.out.println("");
                shop.Shop_Buy( shop.getMoney(), player);
                System.out.println("----------------------------<===>---------------------------");
                System.out.println("");
            System.out.println("Player Health: "+ player.getHealth());
            System.out.println("Player Damage: " + player.getDamage());
            System.out.println("Tamriel      : " + shop.getMoney());
            System.out.println("");
                }
                
            }
            //check monster if ded oor nah--->remove from field.
            if(mc.checkMonster(creature, sizeofmap)==true)  //if monster dies
            {
                mc.moveMonster(creature, sizeofmap);        //if not,then move
            }
            else                                            //if yes then respawn in 10 player moves
            {   
                count++;
                if(count==10)
                {
                    mc.spawnMonster(creature, sizeofmap);
                    count=0;
                }
            }
            
            //showmap
            show=combo.ShowAll(map, creature, sizeofmap);
        }
        
    }
    
    public static void startCombat(int[][] creature,int sizeofmap, int playerdamage,  Combat a, Combat b ){  //true=survive
        
                int playerhealth=a.getHealth();
                int enemyhealth=100;
                Random r = new Random();
                
                int damage=playerdamage, enemydamage=r.nextInt(50), health=playerhealth;
                int temp = a.getDamage();
                a.setHealth(health);
                b.setHealth(enemyhealth);

                while((a.getHealth()>0)&&(b.getHealth()>0)){
                    System.out.println("\nPlayer attacks!");
                    OutputDelay();
                    if(damage<31){
                        a.setDamage(r.nextInt(damage));
                    }else{
                        a.setDamage(r.nextInt(30)+(damage-30));
                    }
                    if(a.getDamage()==0){
                        System.out.println("attack missed!");
                        OutputDelay();
                    }else{
                        b.setHealth(b.getHealth()-a.getDamage());
                        System.out.println("Enemy inflicted "+a.getDamage()+" damage!");
                        OutputDelay();
                    }
                    if(b.getHealth()<=0){
                        System.out.println("Enemy died!");
                        OutputDelay();
                        
                        System.out.println("");
                        creature=RMFM(creature,sizeofmap);                      //remove enemy from map//enemy is ded
                        break;
                    }
                    else{
                        System.out.println("Enemy health: "+b.getHealth());
                        OutputDelay();
                    }
                    System.out.println("\nEnemy attacks!");
                    OutputDelay();
                    if(damage<31){
                        b.setDamage(r.nextInt(enemydamage));
                    }else{
                        b.setDamage(r.nextInt(30)+(enemydamage-30));
                    }
                    if(b.getDamage()==0){
                        System.out.println("attack missed!");
                        OutputDelay();
                    }else{
                        a.setHealth(a.getHealth()-b.getDamage());
                        System.out.println("You inflicted "+ b.getDamage()+" damage!");
                        OutputDelay();
                    }
                    if(a.getHealth()<=0){
                        System.out.println("You died!");
                        creature=RPFM(creature,sizeofmap); 
                        OutputDelay();
                        GMO();
                    
                        break;
                    }else{
                        System.out.println("Your health: "+ a.getHealth());
                        OutputDelay();
                    }
                }a.setDamage(temp);
    }
    
    public static int[][] RMFM(int creature[][],int sizeofmap)
    {
        int x=0,y=0;
            for(int i=0;i<sizeofmap;i++)
            {
                for(int j=0;j<sizeofmap;j++)
                {
                    if(creature[i][j]==8)                                       //find creature.
                    {
                        creature[i][j]=0;                                       //remove creature
                    }
                }
            }
        return creature;
    }
    
    public static int[][] RPFM(int creature[][],int sizeofmap)
    {
        int x=0,y=0;
            for(int i=0;i<sizeofmap;i++)
            {
                for(int j=0;j<sizeofmap;j++)
                {
                    if(creature[i][j]==9)                                       //find creature.
                    {
                        creature[i][j]=0;                                       //remove creature
                    }
                }
            }
        return creature;
    }
    
    public static void GMO(){
        print print = new print();
        print.die();

        System.exit(0);
    }
    
     public static void OutputDelay(){
     try{
            Thread.sleep(1000);
        }
    catch(InterruptedException ex){
        }
    
     }
   
}
