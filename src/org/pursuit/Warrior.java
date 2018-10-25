package org.pursuit;


public class Warrior extends RaidTheStockades {

    String entry;


    public void intro(Player player) {
        System.out.println(player.getName() + "!!! \n" +
                "shouts a voice in the distance, it is your commanding officer accompanied by the Grand Marshal himself.\n" +
                "'This is not an exercise! The city and the bystanders residing within its walls are facing a threat, It is time to\n" +
                "deploy and put your training to the test.' You are scolded by your lieutenant. Now what kind of warrior are you " + player.getName() + "?\n" +
                "\n" +
                "Will you Salute your lieutenant, or scoff at his yelling?\n" +
                "Choose: (SALUTE) or (SCOFF)");
        entry = input.nextLine();
        saluteOrScoff(player);
    }

    public void saluteOrScoff(Player player) {
        do {
            if (playerChoice("salute", entry)) {
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
            } else if (playerChoice("scoff", entry)) {
                System.out.println("HONOR-LESS BOTTOM BARRACK FILTH!");
                System.out.println("You scoff at your lieutenant! This warrior is no foot soldier! You will be reprimanded for this action and be taught the meaning of upholding honor!\n" +
                        "The grand marshal orders your arrest, you are dragged away to the stacks to be receive all forms of physical punishment. This is not how you thought you would spend\n" +
                        "yours days when you joined the royal army.");
                System.out.println("\n " +
                        "Game over " + player.getName() + " Though you are welcome to try again.\n" +
                        "Yes or No Y/n??");
                if (playerChoice("y", input.nextLine())) {
                    startGame();
                } else {
                    endGame();
                }
            }
        } while (playerChoice("1", this.entry));
    }

    public void moveOutOrNot(Player player) {
        do {
            entry = input.nextLine();
            if (playerChoice("1", entry) || playerChoice("move out", entry)) {
                System.out.println("Grand Marshall: " + (player.getGender() == 'M' ? "Mr. " : "Ms. ") + player.getName() + " You are a testament to the honor of our Kingdom. Meet with the Warden and \n" +
                        "prepare for combat, the Stockades are filled with the likes of criminal known for their savagery. The have no respect for life and would willing risk their own if it meant \n" +
                        "a chance to breath the air of freedom once again. \n\n" +
                        "Option 1: Head Straight to the Stockades\n" +
                        "Option 2: Wander around the trade district");
                this.entry = input.nextLine();
                toStocksOrToWander(player);

            } else if (playerChoice("2", entry) || playerChoice("not", entry)) {
                System.out.println("Grand Marshall: ' Let us know when you are ready to move out\n" +
                        "                option 1: 'When do i move out captain?'\n" +
                        "                option 2: 'I am not prepared to take on Such a task.\n" +
                        "                Choose 1 or 2'");

            }
        }while (playerChoice("1", entry) && playerChoice("move out", entry));
    }


    public void toStocksOrToWander(Player player) {
        if (playerChoice("1", entry)) {
            System.out.println("Grand Marshall: 'Now thats the kind of gumption and grit we value around here!'\n" +
                    "You make your way to the Stockades, it is a grim and dreadful place. At first impressions it appears like a watch tower, but you immediately notice that the windows are boarded up\n" +
                    "and that no light an enter or escape. Upon entering you notice a ramp barracaded off with soldier standing behind armed and at the ready; the ramp leads to the prison proper where the \n" +
                    "inmates are celled up. Not a sound escapes from down that ramp. \n" +
                    "The warden approaches you." +
                    "Warden:  'You must be " + player.getName() + " another greenhorn. Had I my way I would return you to the Grand Marshall, but I suppose we are at odds here. At least this one is a " + player.getUserClass() + "\n" +
                    "The other one that arrived is an amateur mage. I don't take kindly to spellbinders on a good day, and I have no appreciation for this one, that's why I'll be teaming you to up. Now be prepared\n" +
                    "what you will find down there is a dungeon full of gnolls, and rogues: imprisoned members of the defias brotherhood gang. You are to go in, walk through the halls and take down any savages, \n" +
                    "put down there leaders and quench this riot.'\n\n" +
                    "You raise your  " + player.getWeapon() + " eager to to taste combat. When you are ready you may charge into the dungeon\n" +
                    "1: (Charge)   2: (Wait)");
            entry = input.nextLine();
            toChargeOrToWait(player);

        } else if (playerChoice("2", entry)) {
            System.out.println("You gesture to the Grand Marshall, you understand what they are asking of you. You shuffle off and as you walk away your mind runs around with the possibilities \n" +
                    "This could be your first time facing real combat. Against honorless criminals, thieves, and murderers. This first combat may easily be your last. You wander the trade district\n" +
                    "You admire the worriless lives of the leatherworkers, blacksmiths, and barmaids. Perhaps one drink before we shoot off? \n" +
                    "1: Drink     2: To the Stocks!");
        }
    }

    public void toChargeOrToWait(Player player) {
        if (playerChoice("1", entry)) {
            System.out.println(" You charge down the ramp, straight into the Stockades. The roaring of countless inmates and soldiers fills the air as you find yourself at the threshold of the\n" +
                    "a long hallway. Soldiers like yourself, and inmates are exchanging blows all about, you see soldiers being dragged out. There are cells on both sides of this hallway and you \n" +
                    "are suddently aware of the danger. ");
            combat(player);
            System.out.println("You have made it to the end of the hallway. You are motivated to find your way through to the mongrel who leads this riot. In front of you is a large cell, while \n" +
                    "to your left and right you see another set of hallways similar to the one you just crossed. While the hallways are littered with inmates looking for a fight, the room in front\n" +
                    "of you seems empty, just one man sits inside observing the long hallway you just came from. Perhaps he is in charge? Or can point you to who might be?\n" +
                    "\n" +
                    "1: Take a (Left)     2: Enter the large (Room)      3: Take a (Right)\n");
            forkInThePrision(player);
        } else if (playerChoice("2", entry)) {
            System.out.println("You looks around this floor of the Stockades, perhaps preparation is the best way to take on this challenge. You find a lance that you believe could help\n" +
                    "in defending yourself and mage comrade. What say you? \n" +
                    "\n" +
                    "Switch to the Lance? Y/N?");
            entry = input.nextLine();
            if (entry.equals("y")) {
                System.out.println("You discard your sword and pick up the pole-arm.");
                player.setWeapon("Lance and Shield");
                entry = "1";
                toChargeOrToWait(player);
            } else {
                entry = "1";
                toChargeOrToWait(player);
            }
        }
    }

    public void forkInThePrision(Player player) {
        do {
            entry = input.nextLine();
            switch (entry) {
                case "1":
                    System.out.println("You take the immediate left. Inmates pour out of their cells and begin to fight for their lives, for them freedom is at stake, for you, honor and glory\n" +
                            "the opportunity to be regarded among ranks of true warriors.");
                    combat(player);
                    System.out.println("You see a door at this end of this hallway, its a dead end, but the room is large and full of inmates standing in a circle");
                    break;
                case "2":
                    System.out.println("You enter the room and slowly approach the inmate inside. He is motionless as you approach, uncaring and unwavering to your presence. You make your final approach\n" +
                            "and begin to question who he is where the riot leader is. At the moment he lunges at you, from atop the support structure of the cell dozens upon dozens of inmates attack you\n" +
                            "You see your receive countless shivs and you recgonize to late this was a trap. The door could only let one person in at a time. No you are outnumbered and you can't swing\n" +
                            "without dropping your guard. It's too late for that, this is where you fall, the last thing you see is a horde of inmates crowding, blood thirsty, stomping and stabbing away.\n" +
                            "\n");
                    endGame();
                    break;
                case "3":
                    System.out.println("You take a right turn, you hold up your shield. Inmates brandish their weapons, some flex their fists enamored at the though of another victim. \n" +
                            "other inmates line the walls of this hallway, giving you a path to the end. It's time to fight your way through.\n" +
                            "\n");
                    combat(player);
                    System.out.println("You did it! You survived this fight but it isn't over, you manage to take only a few steps when another inmate sees his opportunity to strike.");
                    combat(player);
                    System.out.println("\n" +
                            "Victorious! Though you are starting to feeling exhaustion. The inmates that remain in this hallway stand aside, impressed by your strength, the point you to the large \n" +
                            "holding area at the end of this hallway. You enter and are greeted by the sinister: Edwin Van Cleef, the defias brother leader, and of course, the man responsible for inciting\n" +
                            "this riot. \n\n");
                    bossFight(player);
                    break;
                default:
                    entry = "0";
            }
        } while (!entry.equals("1") && !entry.equals("2") && !entry.equals("3"));
    }

    public void bossFight(Player player) {
        entry = "0";
        System.out.println("Van Cleef: 'You have no business here greenhorn! We will find a way out of this prison, freedom awaits me and my brothers while all that awaits you is death.\n" +
                "\n" +
                "This fight won't be like the others, he is skilled and isn't trying to pierce your ribs with a shiv, he has a proper dagger, it's a mystery ");
        for (int i = 0; i < 15; i++) {
            System.out.println("1: Strike quickly    2: Tuck and roll");
            int fightChoice = input.nextInt();

            if (fightChoice == 1) {
                System.out.println("You attack with: " + player.getWeapon());
                if ((randy.nextInt(50) + 1) % 2 == 0) {
                    System.out.println("You are skilled with your " + player.getWeapon() + " and have brought down Van Cleef, you carry his head to doors of the Stockades. This raid is over\n");
                    isWin = true;
                    endGame();
                    break;
                } else {
                    System.out.println("This inmate won't be taken down by you easily, this is Van Cleef! he prepares to strike you again, beware his Sinister Strike!");
                    if (i == 9) {
                        endGame();
                    }
                }
            } else if (fightChoice == 2) {
                if ((randy.nextInt(50) + 1) % 2 == 0) {
                    System.out.println("You defended yourself! fleeing from this enemy and protecting your comrade");
                    break;
                } else {
                    System.out.println("This is Edwin Vancleef!!!! He is clever and he predicts your dodge, at that moment he backstabs you! ");
                    if (i == 14) {
                        endGame();
                    }
                }
            }
        }

    }
}
