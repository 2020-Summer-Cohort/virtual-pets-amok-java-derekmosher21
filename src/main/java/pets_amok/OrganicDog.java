package pets_amok;

public class OrganicDog extends OrganicPets {

    private int cageCleanliness;

    public OrganicDog(String petName, String petDescription, int hunger, int thirst, int waste, int cageCleanliness, int health, int happiness) {
        super(petName, petDescription, hunger, thirst, waste, health, happiness);
        this.cageCleanliness = cageCleanliness;
    }

    public void cleanDogCage() { cageCleanliness = cageCleanliness + 3;}

    public void walkDog() {
        waste--;
        cageCleanliness++;
    }

    @Override
    public void tick(){
        super.tick();
        cageCleanliness--;
    }

    @Override
    public boolean arePetsHealthy() {
        super.arePetsHealthy();
        return getCageCleanliness() > 0;
    }

    public int getCageCleanliness() { return cageCleanliness; }
}
