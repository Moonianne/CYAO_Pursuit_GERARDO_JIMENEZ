package org.pursuit;

import java.util.Random;
import java.util.Scanner;

public class NewCharacter {
    Scanner input = new Scanner(System.in);
    Random randy = new Random();
    private Player player;
    boolean isWin = false;


    public void startGame() {
        this.title();
        this.instructions();
        this.runGame();

    }

    private void title() {
        System.out.println("\n" +
                ">======>                         >=>         >=>                              >=>>=>     >=>                      >=>                      >=>                   \n" +
                ">=>    >=>                >>     >=>         >=>   >=>                      >=>    >=>   >=>                      >=>                      >=>                   \n" +
                ">=>    >=>      >=> >=>          >=>       >=>>==> >=>        >==>           >=>       >=>>==>    >=>        >==> >=>  >=>    >=> >=>      >=>   >==>     >===>  \n" +
                ">> >==>       >=>   >=>  >=>  >=>>=>         >=>   >=>>=>   >>   >=>           >=>       >=>    >=>  >=>   >=>    >=> >=>   >=>   >=>   >=>>=> >>   >=>  >=>     \n" +
                ">=>  >=>     >=>    >=>  >=> >>  >=>         >=>   >=>  >=> >>===>>=>             >=>    >=>   >=>    >=> >=>     >=>=>    >=>    >=>  >>  >=> >>===>>=>   >==>  \n" +
                ">=>    >=>    >=>   >=>  >=> >>  >=>         >=>   >>   >=> >>              >=>    >=>   >=>    >=>  >=>   >=>    >=> >=>   >=>   >=>  >>  >=> >>            >=> \n" +
                ">=>      >=>   >==>>>==> >=>  >=>>=>          >=>  >=>  >=>  >====>           >=>>=>      >=>     >=>        >==> >=>  >=>   >==>>>==>  >=>>=>  >====>   >=> >=>" +
                "\n");
    }

    private void instructions() {
        System.out.println("Welcome, hero! You have elected to take on a quest; the Stockades, a prison holding the most vile and dangerous\n" +
                "criminals known to the world is a midst a riot. The Grand Marshall is calling on the aid of all adventurers to enter the Stockades\n" +
                "bring a halt to the riot and bring order within it's walls. Be courageous and have your wits about, you don't have much time till the \n" +
                "prisonsers attempt an escape and unfortunately,  the Stockades is at the city's center. Good luck, and gods' speed. ");
    }

    public void runGame() {
        player = new Player();
        this.createCharacter();
        if (player.getUserClass().toUpperCase().equals("WARRIOR")) {
            player.setWeapon("Sword &S Shield");
            Warrior warrior = new Warrior();
            warrior.intro(player);
        }

    }

    public void endGame() {
        if (isWin) {
            System.out.println("THE HERO OF THE STOCKADES! RETURN WITH THE HEAD OF VAN CLEEF AND QUELL THE RIOT!\n\n" +
                    "play again?!\n\n" +
                    "Yes/No Y/N?");
            String playAgain = input.nextLine();
            if (playerChoice("y", playAgain)) {
                runGame();
            }
        } else {
            System.out.println("GAME OVER!");
            System.out.println("\nPlay Again?!\n" +
                    "Y/n?");
            if (playerChoice("y", input.nextLine())) {
                runGame();
            }
        }
    }

    public String createCharacter() {
        System.out.println("Begin by creating your character...\n");
        do {
            System.out.println("Male or Female?");
            String playerGender = input.nextLine().toUpperCase();
            if (playerGender.equals("M") || playerGender.equals("MALE")) {
                System.out.println("POOF! You have been endowed with manly attributes and unreasonable sensitivities! A Male you are!");
                player.setGender('M');
            } else if (playerGender.equals("F") || playerGender.equals("FEMALE")) {
                System.out.println("Who says women can't be courageous adventurers! You are a strong independent woman who don't need no man!");
                player.setGender('F');
            } else {
                System.out.println("In this fantasy world, our gender selection is binary, perhaps NewCharacter 2 shall implement this feature");
            }
        } while (player.getGender() != 'M' && player.getGender() != 'F');


        System.out.println("\n What class shall you be?\n" +
                "Choose: Warrior, Mage, or Rogue");


        do {
            player.setUserClass(input.nextLine().toUpperCase());
            switch (player.getUserClass()) {
                case "WARRIOR":
                    System.out.println("You are a Warrior! A Savage who is adept with the sword and shield. You shall fearlessly lead the charge and protect your party in battle.");
                    player.setWeapon("Sword & Shield");
                    break;
                case "MAGE":
                    System.out.println("You are a Mage! An intellectual who studies hard to master the mystic arts, you might be fragile but you hold nothing back to take down an enemy with your explosive attacks.");
                    player.setWeapon("Staff");
                    break;
                case "ROGUE":
                    System.out.println("You are a Rogue! No one will trust you, you are only on these adventures to gain a coin. Others around you don't know your sneaky tactics, you strike swifty and from behind without honor.");
                    player.setWeapon("Dual Daggers");
                    break;
                default:
                    System.out.println("You must select a class!!!");
            }
        }
        while (!player.getUserClass().equals("WARRIOR") && !player.getUserClass().equals("MAGE") && !player.getUserClass().equals("HUNTER") && !player.getUserClass().equals("ROGUE"));

        System.out.println("Ah yes welcome " + (player.getGender() == 'M' ? "Mr. " : "Ms. ") + player.getUserClass() + " i am glad to see you aren't without class.\n" +
                "\n" +
                "What shall we call you?\n" +
                "Type your character name: ");
        setCharName(input.nextLine());
        System.out.println(player.getName() + ", a " + player.getUserClass() + ", and the hero we've been waiting for!\n" +
                "Well, " + player.getName() + " it is time to begin your story.");
        return player.getUserClass();
    }

    public void setCharName(String charName) {
        player.setName(charName);
    }


    Boolean playerChoice(String option, String choice) {
        return option.equals(choice.toLowerCase());
    }


    public void combat(Player player) {
        System.out.println("As you walk down to an inmate comes at you with a shiv\n");
        for (int i = 0; i < 10; i++) {
            System.out.println("1: Strike quickly    2: Tuck and roll");
            int fightChoice = input.nextInt();

            if (fightChoice == 1) {
                System.out.println("You attack with: " + player.getWeapon());
                if ((randy.nextInt(50) + 1) % 2 == 0) {
                    System.out.println("You are skilled with your " + player.getWeapon() + " and have put this inmate down");
                    break;
                } else {
                    System.out.println("This inmate won't be taken down by you easily, he prepares to strike you again");
                    if (assist(player)) {
                        break;
                    }
                    if (i == 9) {
                        endGame();
                    }
                }
            } else if (fightChoice == 2) {
                if ((randy.nextInt(50) + 1) % 2 == 0) {
                    System.out.println("You defended yourself! fleeing from this enemy and protecting your comrade");
                    break;
                } else {
                    System.out.println("This inmate is clever and he predicts your dodge, be prepared strike. ");
                    if (assist(player)) {
                        break;
                    }
                    if (i == 9) {
                        endGame();
                    }
                }
            }
        }
    }

    protected boolean assist(Player player) {
        int random = randy.nextInt(100) + 1;

        if (random % 3 == 0) {
            if (player.getUserClass().equals("WARRIOR")) {
                System.out.println("...\n" +
                        "...\n" +
                        "...\n" +
                        "The amateur mage successfully conjures a Fire Blast! Striking its target and burning him to ashes.\n" +
                        "you are both safe to continue pressing forward!\n" +
                        "");
                return true;
            } else if (player.getUserClass().equals("MAGE")) {
                System.out.println("...\n" +
                        "...\n" +
                        "...\n" +
                        "This young warrior is brutish and will protect you with his own life! He Blocks the enemy with his shield and\n" +
                        "land a definitive blow. You are both safe to contine pressing forward.\n" +
                        " ");
                return true;
            }
        }
        return false;
    }
}
