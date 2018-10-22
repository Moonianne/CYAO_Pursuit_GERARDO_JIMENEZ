package org.pursuit;

import java.util.Random;
import java.util.Scanner;

public class RaidTheStockades extends RolePlayingGame {
    Scanner input = new Scanner(System.in);
    Random randy = new Random();
    private Player player;


    @Override
    public void startGame() {

        player = new Player();

        this.title();
        this.instructions();
        this.createCharacter();
        if (getPlayerClass().toUpperCase().equals("WARRIOR")) {
            Warrior warrior = new Warrior();
            warrior.intro(player);
        }
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

    @Override
    public void runGame() {

    }

    @Override
    public void endGame() {
        System.out.println("GAME OVER!");
    }

    public String createCharacter() {
        System.out.println("Begin by creating your character...\n");
        do {
            System.out.println("Male or Female?");
            player.setGender(input.nextLine().toUpperCase().charAt(0));
            if (player.getGender() == 'M') {
                System.out.println("POOF! You have been endowed with manly attributes and unreasonable sensitivities! A Male you are!");
            } else if (player.getGender() == 'F') {
                System.out.println("Who says women can't be courageous adventurers! You are a strong independent woman who don't need no man!");
            } else {
                System.out.println("In this fantasy world, our gender selection is binary, perhaps RaidTheStockades 2 shall implement this feature");
            }
        } while (player.getGender() != 'M' && player.getGender() != 'F');


        System.out.println("\n What class shall you be?\n" +
                "Choose: Warrior, Hunter, Mage, or Rogue");


        do {
            setPlayerClass(input.nextLine().toUpperCase());
            switch (playerClass) {
                case "WARRIOR":
                    System.out.println("You are a Warrior! A Savage who is adept with the sword and shield. You shall fearlessly lead the charge and protect your party in battle.");
                    setPlayerWeapon("Sword & Shield");
                    break;
                case "HUNTER":
                    System.out.println("You are a Hunter! A marksman like no other, your bow never misses it's target whilst you keep your distance and deal savage critical damage");
                    setPlayerWeapon("Long Bow");
                    break;
                case "MAGE":
                    System.out.println("You are a Mage! An intellectual who studies hard to master the mystic arts, you might be fragile but you hold nothing back to take down an enemy with your explosive attacks.");
                    setPlayerWeapon("Staff");
                    break;
                case "ROGUE":
                    System.out.println("You are a Rogue! No one will trust you, you are only on these adventures to gain a coin. Others around you don't know your sneaky tactics, you strike swifty and from behind without honor.");
                    setPlayerWeapon("Dual Daggers");
                    break;
                default:
                    System.out.println("You must select a class!!!");
            }
        }
        while (!playerClass.equals("WARRIOR") && !playerClass.equals("MAGE") && !playerClass.equals("HUNTER") && !playerClass.equals("ROGUE"));

        System.out.println("Ah yes welcome " + (player.getGender() == 'M' ? "Mr. " : "Ms. ") + playerClass + " i am glad to see you aren't without class.\n" +
                "\n" +
                "What shall we call you?\n" +
                "Type your character name: ");
        setCharName(input.nextLine());
        System.out.println(player.getName() + ", a " + playerClass + ", and the hero we've been waiting for!\n" +
                "Well, " + player.getName() + " it is time to begin your story.");
        return playerClass;
    }

    public void setCharName(String charName) {
        player.setName(charName);
    }


    @Override
    Boolean playerChoice(String option) {
        String usersChoice = input.nextLine();
        return usersChoice.equals(option.toLowerCase());
    }

    @Override
    void playerRoll() {
    }

    @Override
    void nonPlayerRoll() {
    }


}
