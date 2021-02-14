package com.example.Tamagotchi_Towers.models.animals;

public enum AnimalType {

    DOG(1.75,1.5,1,1.5, "https://i.imgur.com/P2powxq.gif",
            "https://i.imgur.com/1TQHaou.gif", "https://i.imgur.com/WHiDeAH.gif",
            "https://i.imgur.com/m5SCDfD.gif"),

    CAT(1.5,1, 1.25, 1.25,"https://i.imgur.com/FUcxecn.gif",
            "https://i.imgur.com/KwTXbKe.gif","https://i.imgur.com/nRZ7yyc.gif",
            "https://i.imgur.com/6DF5S1o.gif"),

    MONKEY(2, 1.75, 1.5, 1.75,"https://i.imgur.com/FpdcJPU.gif",
            "https://i.imgur.com/RX8PkFG.gif","https://i.imgur.com/Im9hDxi.gif",
            "https://i.imgur.com/0Fe2tz6.gif"),

    PENGUIN(2,1.9,1, 1.5,"https://i.imgur.com/zD82JAK.gif",
            "https://i.imgur.com/xX6hHaa.gif","https://i.imgur.com/2owJgtb.gif",
            "https://i.imgur.com/v0h7PxU.gif"),

    UNICORN(2.5,1.5,1.5,2,"https://i.imgur.com/j4AhpbF.gif",
            "https://i.imgur.com/X2EtTDw.gif","https://i.imgur.com/laAfvMO.gif",
            "https://i.imgur.com/Rdebz4G.gif"),

    DINOSAUR(3,1.5,2.5, 2.5,"https://i.imgur.com/GJfRDl4.gif",
            "https://i.imgur.com/wE4rxJj.gif","https://i.imgur.com/pPd3cb3.gif",
            "https://i.imgur.com/4CAasgr.gif");

    private final double appetite;
    private final double grooming;
    private final double cheeriness;
    private final double activityLevel;
    private final String speak;
    private final String heart;
    private final String exclamation;
    private final String rip;

    AnimalType(double appetite, double grooming, double cheeriness, double activityLevel,
               String speak, String heart, String exclamation, String rip){
        this.appetite = appetite;
        this.grooming = grooming;
        this.cheeriness = cheeriness;
        this.activityLevel = activityLevel;
        this.speak = speak;
        this.heart = heart;
        this.exclamation = exclamation;
        this.rip = rip;
    }

    public double getAppetite() {
        return appetite;
    }

    public double getGrooming() {
        return grooming;
    }

    public double getCheeriness() {
        return cheeriness;
    }

    public double getActivityLevel() {
        return activityLevel;
    }

    public String getSpeak() {
        return speak;
    }

    public String getHeart() {
        return heart;
    }

    public String getExclamation() {
        return exclamation;
    }

    public String getRIP() {
        return rip;
    }
}
