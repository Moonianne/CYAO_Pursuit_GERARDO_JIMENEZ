package org.pursuit;

public abstract class RolePlayingGame implements Game{
    private int playerDice;
    private int npcDice;
    public String playerClass;
    public String playerWeapon;


    abstract Boolean playerChoice(String option, String choice);

    abstract void playerRoll();

    abstract void nonPlayerRoll();

    public int getPlayerDice() {
        return playerDice;
    }

    public void setPlayerDice(int playerDice) {
        this.playerDice = playerDice;
    }

    public int getNpcDice() {
        return npcDice;
    }

    public void setNpcDice(int npcDice) {
        this.npcDice = npcDice;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }
}
