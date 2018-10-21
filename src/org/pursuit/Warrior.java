package org.pursuit;

public class Warrior extends RaidTheStockades {



    public void intro(Player player) {
        System.out.println(player.getName() + "!!! \n" +
                "shouts a voice in the distance, it is your commanding officer accompanied by the Grand Marshal himself.\n" +
                "'This is not an exercise! The city and the bystanders residing within its walls are facing a threat, It is time to\n" +
                "deploy and put your training to the test.' You are scolded by your lieutenant. Now what kind of warrior are you " + player.getName() + "?\n" +
                "\n" +
                "Will you Salute your lieutenant, or scoff at his yelling?\n" +
                "Choose: (SALUTE) or (SCOFF)");
        String playerChoice = playerChoice().toUpperCase();
        if (playerChoice.equals("SALUTE")) {
            System.out.println("You Salute your lieutenant!");
            salute(player);
        } else if (playerChoice.equals("SCOFF")){
            System.out.println("HONOR-LESS BOTTOM BARRACK FILTH!");
            scoff(player);
        }
    }

    public void salute(Player player) {
        System.out.println("Grand Marshall: You are quite the soldier " + player.getName() + " the lieutenant here speaks highly of you, don't take his tone to heart, /\n" +
                "it is important to stress this discipline of a warrior and his test his honor through battle. Now for the matter at hand. This is your Call to Arms! A riot within the \n" +
                "Stockades his become quite the seen, the guards within are cornered and lost to us if we don't send in troops to help. \n " +
                "Find your way to the stockades and prepare yourself and your company to raid them, take down the prison chiefs inside, and restore order." +
                "\n" +
                "option 1: 'When do i move out captain?'\n" +
                "option 2: 'I am not prepared to take on Such a task.'");
    }

    public void moveOut(Player player) {
        System.out.println("Grand Marshall: " + (player.getGender() == 'M' ? "Mr. " : "Ms. ") + player.getName() + " You are a testament to the honor of our Kingdom. Meet with the Warden and \n" +
                "prepare for combat, the Stockades are filled with the likes of criminal known for their savagery. The have no respect for life and would willing risk their own if it meant \n" +
                "a change to breath the air of freedom once again.");
    }

    public void scoff(Player player) {
        System.out.println("You scoff at your lieutenant! This warrior is no foot soldier! You will be reprimanded for this action and be taught the meaning of upholding honor!\n" +
                "The grand marshal orders your arrest, you are dragged away to the stacks to be receive all forms of physical punishment. This is not how you thought you would spend\n" +
                "yours days when you joined the royal army.");
        System.out.println("\n " +
                "Game over " + player.getName() + " Though you are welcome to try again.\n" +
                "Yes or No Y/n??");
        if (playerChoice().toUpperCase().equals("Y")){
            startGame();
        } else {
            endGame();
        }

    }
}
