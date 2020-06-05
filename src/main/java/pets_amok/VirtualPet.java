package pets_amok;

public class VirtualPet {
    private String petName;
    private String petDescription;
    private int health;
    private int happiness;

    public VirtualPet(String petName, String petDescription, int health, int happiness) {
        this.health = health;
        this.happiness = happiness;
        this.petName = petName;
        this.petDescription = petDescription;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }


    public void playWithPet() {
        happiness = happiness + 5;
        health++;
    }

    public void tick() {
        happiness--;
        health--;
    }

    public boolean arePetsHealthy() {
        return getHealth() > 0 && getHappiness() > 0;
    }

}