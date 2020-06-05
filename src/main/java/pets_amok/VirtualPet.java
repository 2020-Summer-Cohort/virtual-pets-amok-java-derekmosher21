package pets_amok;

public class VirtualPet {
    private String petName;
    private String petDescription;
    private int hunger;
    private int thirst;
    private int happiness;

    public VirtualPet(String petName, String petDescription, int hunger, int thirst, int happiness) {
        this.hunger = hunger;
        this.thirst = thirst;
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

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feedPet() {
        hunger = hunger - 4;
        thirst++;
    }

    public void waterPet() {
        thirst = thirst - 3;
        hunger++;
    }

    public void playWithPet() {
        happiness = happiness + 5;
        hunger++;
        thirst++;
    }

    public void tick() {
        hunger++;
        thirst++;
        happiness--;
    }

    protected boolean arePetsHealthy() {
        return getHunger() < 20 && getThirst() < 20 && getHappiness() > 0;
    }

}