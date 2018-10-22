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

        saluteOrScoff(player);
    }

    public void saluteOrScoff(Player player) {
        if (playerChoice("saluteOrScoff")) {
            System.out.println("You Salute your lieutenant!");
            System.out.println("Grand Marshall: You are quite the soldier " + player.getName() + " the lieutenant here speaks highly of you, don't take his tone to heart, /\n" +
                    "it is important to stress this discipline of a warrior and his test his honor through battle. Now for the matter at hand. This is your Call to Arms! A riot within the \n" +
                    "Stockades his become quite the seen, the guards within are cornered and lost to us if we don't send in troops to help. \n " +
                    "Find your way to the stockades and prepare yourself and your company to raid them, take down the prison chiefs inside, and restore order." +
                    "\n" +
                    "option 1: 'When do i move out captain?'\n" +
                    "option 2: 'I am not prepared to take on Such a task.\n" +
                    "Choose 1('move out') or 2('not')");
            moveOutOrNot(player);
        } else if (playerChoice("scoff")) {
            System.out.println("HONOR-LESS BOTTOM BARRACK FILTH!");
            System.out.println("You scoff at your lieutenant! This warrior is no foot soldier! You will be reprimanded for this action and be taught the meaning of upholding honor!\n" +
                    "The grand marshal orders your arrest, you are dragged away to the stacks to be receive all forms of physical punishment. This is not how you thought you would spend\n" +
                    "yours days when you joined the royal army.");
            System.out.println("\n " +
                    "Game over " + player.getName() + " Though you are welcome to try again.\n" +
                    "Yes or No Y/n??");
            if (playerChoice("y")) {
                startGame();
            } else {
                endGame();
            }
        }
    }

    public void moveOutOrNot(Player player) {
        do {
            if (playerChoice("1") || playerChoice("move out")) {
                System.out.println("Grand Marshall: " + (player.getGender() == 'M' ? "Mr. " : "Ms. ") + player.getName() + " You are a testament to the honor of our Kingdom. Meet with the Warden and \n" +
                        "prepare for combat, the Stockades are filled with the likes of criminal known for their savagery. The have no respect for life and would willing risk their own if it meant \n" +
                        "a chance to breath the air of freedom once again. \n\n" +
                        "Option 1: Head Straight to the Stockades\n" +
                        "Option 2: Wander around the trade district");

            } else if (playerChoice("2") || playerChoice("not")) {
                System.out.println("Grand Marshall: ' Let us know when you are ready to move out\n" +
                        "                option 1: 'When do i move out captain?'\n" +
                        "                option 2: 'I am not prepared to take on Such a task.\n" +
                        "                Choose 1 or 2'");
            }
        } while (playerChoice("1") && playerChoice("move out"));

    }

    public void toStocksOrToWander(Player player) {
        if (playerChoice("1")) {
            System.out.println("Grand Marshall: 'Now thats the kind of gumption and grit we value around here!'\n" +
                    "You make your way to the Stockades, it is a grim and dreadful place. At first impressions it appears like a watch tower, but you immediately notice that the windows are boarded up\n" +
                    "and that no light an enter or escape. Upon entering you notice a ramp barracaded off with soldier standing behind armed and at the ready; the ramp leads to the prison proper where the \n" +
                    "inmates are celled up. Not a sound escapes from down that ramp. \n" +
                    "The warden approaches you." +
                    "Warden:  You must be " + player.getName() + " another greenhorn. Had I my way I would return you to the Grand Marshall, but I suppose we are at odds here. Atleast this one is a " + player.getUserClass() + "\n" +
                    "The other one that arrived is a amateur Mage.");
        }
    }


}
