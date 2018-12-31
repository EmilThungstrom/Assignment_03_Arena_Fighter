package data;

import java.util.Random;

public class Person {

    public int health;
    public int attack;
    public int defence;

    public Person(int health, int attack, int defence){
        this.health = health;
        this.attack = attack;
        this.defence = defence;
    }
    public Person(Random random){
        this.health = random.nextInt(10) + 1;
        this.attack = random.nextInt(10) + 1;
        this.defence = random.nextInt(10) + 1;
    }

}
