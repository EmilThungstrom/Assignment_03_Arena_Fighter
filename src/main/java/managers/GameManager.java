package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.Hero;

public class GameManager {

    private static RandomManager randomManager = new RandomManager();
    private static BattleManager battleManager = new BattleManager();
    private static Scanner scanner = new Scanner(System.in);

    private List<List<String>> battleHistory;
    private Hero hero;

    public void gameLoop(){
        System.out.println("<<BattleManager Limited Deluxe Mega Super Edition>>");
        System.out.println("---------------------------------------------------");
        newHero();

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("Enter 1 if you want to fight in the arena");
            System.out.println("Enter 2 if you want to review your hero");
            System.out.println("Enter 3 if you want to review a fight");
            System.out.println("Enter 4 if you want to retire");

            switch (Integer.valueOf(scanner.nextLine())){

                case 1:
                    fight();
                    break;
                case 2:
                    reviewHero();
                    break;
                case 3:
                    reviewFight();
                    break;
                case 4:
                    calculateScore();
                    break;
            }
        }
    }
    private void newHero(){

        battleHistory = new ArrayList<List<String>>();
        System.out.println("Enter the hero's name");
        String tempN = scanner.nextLine();
        System.out.println("Enter the health value for your hero");
        int tempH = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the attack value for your hero");
        int tempA = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter the defence value for your hero");
        int tempD = Integer.valueOf(scanner.nextLine());

        hero = new Hero(tempH, tempA, tempD, tempN);
    }
    private void fight() {
        boolean result = battleManager.fight(randomManager, hero);
        battleHistory.add(battleManager.fightEvents);
        printFight();

        if(!result)
            calculateScore();
    }
    private void reviewHero(){
        System.out.println("<<< HERO >>");
        System.out.println("Name: " + hero.name);
        System.out.println("Health: " + Integer.valueOf(hero.maxHealth));
        System.out.println("Attack: " + Integer.valueOf(hero.attack));
        System.out.println("Defense: " + Integer.valueOf(hero.defence));
        System.out.println("Battles fought: " + Integer.valueOf(battleHistory.size()));
    }
    private void reviewFight(){
        System.out.println("---------------------------------------------------");
        System.out.println("There are " + Integer.valueOf(battleHistory.size()) + " battles stored for this hero");
        System.out.println("Enter the battle you want to review");
        printFight(Integer.valueOf(scanner.nextLine()));
    }
    private void printFight(){
        printFight(battleHistory.size());
    }
    private void printFight(int battle){
        for (String event : battleHistory.get(battle - 1)) {
            System.out.println(event);
        }
    }
    private void calculateScore(){
        System.out.println("<<< SCORE: " + Integer.valueOf(battleHistory.size()) + " >>>");
        newHero();
    }
}
