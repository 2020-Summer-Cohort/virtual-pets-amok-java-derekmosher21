package pets_amok;

public class RoboticPets extends VirtualPet implements RoboticActions {

    private int oilLevel;

    public RoboticPets(String petName, String petDescription, int oilLevel, int health, int happiness ) {
        super(petName, petDescription, health, happiness); ;
        this.oilLevel = oilLevel;

    }

    @Override
    public void oilPet() { oilLevel++; }

    @Override
    public boolean arePetsHealthy() {
        return  getOilLevel() > 0;
    }

    @Override
    public void tick() {
        super.tick();
        oilLevel--;
    }

    public int getOilLevel() { return oilLevel; }

}


