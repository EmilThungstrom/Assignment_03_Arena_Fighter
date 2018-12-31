package data;

public class Hero extends Person {

    public String name;
    public int maxHealth;

    public Hero(int health, int attack, int defence, String name){
        super(health, attack, defence);
        this.name = name;
        maxHealth = health;
    }
}
