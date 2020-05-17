/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */

public class Combat {
    private int health;
    private int damage;
    Random r = new Random();
    
    public Combat(){
//       health = 100;
//       damage = 40;
    }
    
    public Combat(int health, int damage){
        this.health=health;
        this.damage=damage;
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setHealth(int health){
        this.health=health;
    }
    
    public void setDamage(int damage){
        this.damage=damage;
    }
    
    
     
    
}
