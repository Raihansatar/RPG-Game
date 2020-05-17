/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Scanner;

/**
 *
 * @author Raihan
 */
public class Shop extends Combat{
    
    Scanner scan = new Scanner(System.in);
    private int money, damage;
    
    public Shop (){
        money=100;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int money){
        this.money=money;
    }
    
    
    
    public void Shop_Buy( int tamriel, Combat a){
        System.out.println("Player Health: "+ a.getHealth());
        System.out.println("Player Damage: " + a.getDamage());
        System.out.println("Tamriel      : " + getMoney());
        System.out.println("");
        System.out.println("\n \n");
        Message_Shop();
       int buychoice=scan.nextInt();
    switch(buychoice){
        case 1: if(tamriel>=50){
                    tamriel=tamriel-50;
                    a.setDamage(a.getDamage()+16);
                    setMoney(tamriel);
                    System.out.println("You have buy an excalibur (Damage +16) ");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                }Shop_Buy( tamriel,  a);
                break;
                
        case 2: if(tamriel>=40){
                    tamriel=tamriel-40;
                    a.setDamage(a.getDamage()+12);
                    setDamage(damage);
                    setMoney(tamriel);
                    System.out.println("You have buy a blue frost sword (Damage +12)");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                }Shop_Buy( tamriel,  a);
                break;
    
        case 3: if(tamriel>=36){
                    tamriel=tamriel-36;
                    a.setDamage(a.getDamage()+19);
                    setDamage(damage);
                    setMoney(tamriel);
                    System.out.println("You have buy a dragobnane (Damage +19)");
                }
                else{
                    System.out.println("Not enough tamriel");
//                   Shop_Buy(damage, tamriel,  a);
                    }Shop_Buy( tamriel,  a);
                    break;
         
        
        case 4: if(tamriel>=38){
                    tamriel=tamriel-38;
                    a.setDamage(a.getDamage()+11);
                    setDamage(damage);
                    setMoney(tamriel);
                    System.out.println("You have buy a bloodscythe (Damage +11)");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                    }  Shop_Buy( tamriel,  a);
                    break;
        
        case 5:if(tamriel>=37){
                    tamriel=tamriel-37;
                    a.setDamage(a.getDamage()+10);
                    setDamage(damage);
                    setMoney(tamriel);
                    System.out.println("You have buy a Mehrun' Razor (Damage +10) ");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                    }  Shop_Buy( tamriel,  a);
                    break;
        case 6:if(tamriel>=10){
                    tamriel=tamriel-10;
                    a.setHealth(a.getHealth()+10);
                    setMoney(tamriel);
                    System.out.println("You restored 10 health");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                    }Shop_Buy( tamriel,  a);
                    break;
        case 7:if(tamriel>=20){
                    tamriel=tamriel-20;
                    a.setHealth(a.getHealth()+10);
                    setMoney(tamriel);
                    System.out.println("You restored 20 health");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                    }Shop_Buy( tamriel,  a);
                    break;
        case 8:if(tamriel>=50){
                    tamriel=tamriel-50;
                    a.setHealth(a.getHealth()+50);
                    setMoney(tamriel);
                    System.out.println("You restored 50 health");
                }
                else{
                    System.out.println("Not enough tamriel");
//                    Shop_Buy(damage, tamriel,  a);
                    }Shop_Buy( tamriel,  a);
                    break;
               
        case 9:System.out.println("Thank you, Come again soon.");
               System.out.println("---You've exit the shop---");
               System.out.println("");
               break;
                
        default:
            System.out.println("I don't quite get what you mean by that...");
            Shop_Buy( tamriel,  a);
        }
    
    }
     public void Message_Shop(){  //popup sitem list
        System.out.println("Welcome to the shop?\nHere we sell some weapon to ease your journey");
        OutputDelay();
        System.out.println("1: EXCALIBUR (DAMAGE:16)             (50 TAMRIEL)");
        OutputDelay();
        System.out.println("2: BLUE FROST SWORD (DAMAGE:12)      (40 TAMRIEL)");
        OutputDelay();
        System.out.println("3: DRAGONBANE (DAMAGE:9)             (36 TAMRIEL)");
        OutputDelay();
        System.out.println("4: BLOODSCYTHE (DAMAGE: 11)          (38 TAMRIEL)");
        OutputDelay();
        System.out.println("5: MEHRUN'S RAZOR(DAMAGE:10)         (37 TAMRIEL)");
        OutputDelay();
        System.out.println("6: POTION 10 (HEALTH:10)             (10 TAMRIEL)");
        OutputDelay();
        System.out.println("7: POTION 20 (HEALTH:20)             (20 TAMRIEL)");
        OutputDelay();
        System.out.println("8: POTION 50 (HEALTH: 50)            (50 TAMRIEL)");
        OutputDelay();
        System.out.println("9: EXIT                                          ");
        OutputDelay();
        System.out.print("Please enter a number to buy: ");
    }
     
    public static void OutputDelay(){
     try{
            Thread.sleep(500);
        }
    catch(InterruptedException ex){
        }
    
    }
}
