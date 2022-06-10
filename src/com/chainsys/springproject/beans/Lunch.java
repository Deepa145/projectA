package com.chainsys.springproject.beans;

public class Lunch {

    private Starters entree;
    private Maincourse mainfood;
    private Desert sweets;
    // Constructors based Dependency injection
    public Lunch(Starters s , Maincourse m, Desert d) {
        System.out.println("Lunch is ready");
        entree=s;
        mainfood=m;
        sweets=d;
    }
    public void serve() {
        System.out.println(entree.name);
        System.out.println(mainfood.name);
        System.out.println(sweets.name);
        
    }
}
/*
 * Lunch
 * Starters,Chicken,Soup,Vegroll
 * Maincourse,SouthIndian,Northindian,Chinese
 * Deserts,Icecream,Sweets,Cakes
 */