/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.Random;

/**
 *
 * @author Raihan
 */
public class RandomMessage {
    print print = new print();
    public RandomMessage(){
        
    }
    
    public void Message_Civilian_NPC(){
        Random rgen = new Random();
        int Message_NPC;
        Message_NPC=rgen.nextInt(24);
        switch (Message_NPC) {
            case 0:
                print.trollface();
                break;
            case 1:
                print.huh();
                break;
            case 2:
               
                print.Cat();
                break;
            case 3:
                print.MicScream();
                break;
            case 4:
                print.JackyHuh();
                break;
            case 5:
                print.JokerFace();
                break;
            case 6:
                print.WaitWhat();
                break;
            case 7:
                print.MicHold();
                break;
            case 8:
                print.Sad();
                break;
            case 9:
                print.MarioJump();
                break;
            case 10:
                
                print.HappyHi();
                break;
            case 11:
                
                print.Okay();
                break;
            case 12:
                System.out.println("Do not forget to perform your solat eventhough how busy you are");
                break;
                
            case 13:
                 System.out.println("Behold the power of my new jutsu.......................\n ");
                OutputDelay();
                System.out.println("*poff.......poff........poff \n ");
                OutputDelay();
                System.out.println("*it smoke everywhere.............\n");
                OutputDelay();
                System.out.println("*nothing happens");
                break;
            case 14:
                System.out.println("( ͡°( ͡° ͜ʖ( ͡° ͜ʖ ͡°)ʖ ͡°) ͡°)");
                break;
            case 15:
                System.out.println("(ღ˘⌣˘ღ) ");
                break;
            case 16:
                System.out.println("(ó ì_í)=óò=(ì_í ò)");
                break;
            case 17:
                System.out.println("┬──┬ ノ( ゜-゜ノ)");
                break;
            case 18:
                System.out.println("(•_•) ( •_•)>⌐■-■ (⌐■_■)");
                break;
            case 19:
                System.out.println("༼ ºل͟º ༼ ºل͟º ༼ ºل͟º ༽ ºل͟º ༽ ºل͟º ༽");
                break;
            case 20:
                System.out.println("/╲/\\╭( ͡° ͡° ͜ʖ ͡° ͡°)╮/\\╱\\");
                break;
            case 21:
                System.out.println("I SAW RAYQUAZA FLYING OVER THEREEEE !!! OMGGG");
                break;
            case 22:
                System.out.println("There a rumor said that DOVAHKIN IS COMINGG");
                break;
            case 23:
                 System.out.println("Why are you running, ");
                OutputDelay();
                System.out.println(" why are you running !!! ");
                break;
                    
            default:
                System.out.println("Have you seen my crush ??????");
                OutputDelay();
                break;
        }
        
    }

    
    
    public static void OutputDelay(){
     try{
            Thread.sleep(1000);
        }
    catch(InterruptedException ex){
        }
    
    }
    
}
