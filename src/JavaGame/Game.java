package JavaGame;
import java.util.*;

public class Game {
    public static void main(String[] args) {

//        System Objects
        Scanner scn = new Scanner(System.in);
        Random random = new Random();
//        Enemy variables
        String[] enemies = { "Skelton","Zombie" , "Warrior", "Assasian" };
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;
//        Player Variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 3;
        int healthPotionAmount = 30;
        int healthPotionDropChance = 50; //percentage
        System.out.println("WELCOME TO THE DUNGEON!");
        Boolean running = true;
        GAME:
        while(running){
            System.out.println("--------------------------------------------");
            String enemy = enemies[random.nextInt(enemies.length)];
            int enemyhealth = random.nextInt(maxEnemyHealth);
            System.out.println("\t# "+enemy+" has appeared! #\n");

            while (enemyhealth>0){
                System.out.println("\tYour HP : "+health);
                System.out.println("\t"+enemy+"'s HP : "+enemyhealth);
                System.out.println("\n\tWhat would you like to do");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink Health Potion");
                System.out.println("\t3.Run!");

                String input = scn.nextLine();

                if (input.equals("1")){
                int damageDealt = random.nextInt(attackDamage);
                int damageTaken = random.nextInt(enemyAttackDamage);
                enemyhealth -= damageDealt;
                health -= damageTaken;

                    System.out.println("\t> You Strike "+enemy+" for "+damageDealt+" damage");
                    System.out.println(("\t> You receive "+damageTaken+" in retaliation"));

                    if (health<1){
                        System.out.println("\t> You have taken too much damage , you're too weak to go on ");
                        break;
                    }


                }
                else if(input.equals("2")){
                    if(numHealthPotion>0){
                        health+=healthPotionAmount;
                        numHealthPotion--;
                        System.out.println("\t> You've drink a health potion , healing yourself for "+healthPotionAmount+"."
                        +" \n\t> You now have "+health+"HP"
                        +"\n\t> You have "+numHealthPotion+" health potion left.\n");
                    }
                    else{
                        System.out.println("\t> You've no health potion left! Defeat enemies for a chance to get one.\n");
                    }
                }
                else if (input.equals("3")){
                    System.out.println("\t> You run away from the "+enemy+"!");
                    continue GAME;
                }
                else{
                    System.out.println("Invalid Command");
                }
            }
            if (health<1){
                System.out.println("\t> You limpout from the dungeon , you're too weak for thr battle!");
                break;
            }
            System.out.println("--------------------------------------------");
            System.out.println(" # "+enemy+" is defeated! #");
            System.out.println(" # You've "+health+" HP left! #");
            if (random.nextInt(100)<healthPotionDropChance){
                numHealthPotion++;
                System.out.println(" # the "+enemy+" dropped a health potion # ");
                System.out.println(" # you've now "+numHealthPotion+" health potion(s) #");

            }
            System.out.println("--------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Countinue dungeon");
            System.out.println("2. Exit dungeon");

            String input = scn.nextLine();

            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid Command");
                input = scn.nextLine();
            }
            if (input.equals("1")){
                System.out.println("You continue on your advanture!");
            }
            else if(input.equals("2")){
                System.out.println("Exit the dungeon , successful in advanture!");
                break;
            }
        }
        System.out.println("##########################");
        System.out.println("##  THANKS FOR PLAYING  ##");
        System.out.println("##########################");
    }
}
