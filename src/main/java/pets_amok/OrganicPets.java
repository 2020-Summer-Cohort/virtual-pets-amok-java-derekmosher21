package pets_amok;

public class OrganicPets extends VirtualPet implements OrganicActions {
    protected int thirst;
    protected int hunger;
    protected int waste;

    public OrganicPets(String petName, String petDescription, int hunger, int thirst, int waste, int health, int happiness) {
        super(petName, petDescription, health, happiness);
        this.hunger = hunger;
        this.thirst = thirst;
        this.waste = waste;
    }

    @Override
    public void feed() {
        this.hunger = this.hunger - 3;
        this.thirst++;
        this.waste++;
    }

    @Override
    public void water() {
        this.thirst = this.thirst - 3;

    }

    @Override
    public void playWithPet() {
        super.playWithPet();
        this.hunger++;
        this.thirst++;
    }

    @Override
    public void tick() {
        super.tick();
        this.hunger++;
        this.thirst++;
        this.waste++;
    }

    @Override
    public boolean arePetsHealthy() {
        return super.getHealth() > 0 && super.getHappiness() > 0 && getThirst() < 20 && getHunger() < 20 && getWaste() < 20;
    }

    public int getThirst() {
        return thirst;
    }

    public int getHunger() {
        return hunger;
    }

    public int getWaste() {
        return waste;
    }

}
