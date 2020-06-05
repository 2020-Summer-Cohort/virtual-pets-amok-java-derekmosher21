package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    private Map<String, VirtualPet> pets = new HashMap<>();

    public Map<String, VirtualPet> getPets() {
        return pets;
    }

    public VirtualPet getVirtualPet(String requestedPetName) {
        VirtualPet pet = null;
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            String petName = mapEntry.getKey();
            if (requestedPetName.equals(petName)) {
                pet = mapEntry.getValue();
            }
        }
        return pet;
    }

    public void addPet(VirtualPet petToAdd) {
        pets.put(petToAdd.getPetName(), petToAdd);
    }

    public void removePet(String petNameAdopted) {
        pets.remove(petNameAdopted);
    }

    public void feedAllPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicPets) {
                ((OrganicPets) mapEntry.getValue()).feed();
            }
        }
    }

    public void waterAllPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicPets) {
                ((OrganicPets) mapEntry.getValue()).water();
            }
        }
    }

    public void playWithOnePet(String requestedPetName) {
        VirtualPet pet = getVirtualPet(requestedPetName);
        pet.playWithPet();
    }

    public void walkAllDogs() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicDog) {
                ((OrganicDog) mapEntry.getValue()).walkDog();
            }
        }
    }

    public void oilRoboticPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof RoboticPets) {
                ((RoboticPets) mapEntry.getValue()).oilPet();
            }
        }
    }

    public void cleanAllDogsCages() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicDog) {
                ((OrganicDog) mapEntry.getValue()).cleanDogCage();
            }
        }
    }

    public void tickAllPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicDog) {
                ((OrganicDog) mapEntry.getValue()).tick();
            } else if (mapEntry.getValue() instanceof OrganicPets) {
                ((OrganicPets) mapEntry.getValue()).tick();
            } else if (mapEntry.getValue() instanceof RoboticPets) {
                ((RoboticPets) mapEntry.getValue()).tick();
            } else {
                VirtualPet pet = mapEntry.getValue();
                pet.tick();
            }
        }
    }


    protected boolean checkHealthOfAllPets() {
        boolean checkHealthOfAllPets = true;
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicDog) {
                return ((OrganicDog) mapEntry.getValue()).arePetsHealthy();
            } else if (mapEntry.getValue() instanceof OrganicPets) {
                return ((OrganicPets) mapEntry.getValue()).arePetsHealthy();
            } else if (mapEntry.getValue() instanceof RoboticPets) {
                return ((RoboticPets) mapEntry.getValue()).arePetsHealthy();
            }
        }
        return checkHealthOfAllPets;

    }

    public void printNamesAndDescriptions() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            String petName = mapEntry.getKey();
            String petDescription = mapEntry.getValue().getPetDescription();
            System.out.println(petName + " -- " + petDescription);
        }
    }

    public void getPetHealthStatus() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            if (mapEntry.getValue() instanceof OrganicDog) {
                String petName = mapEntry.getKey();
                int petHunger = ((OrganicDog) mapEntry.getValue()).getHunger();
                int petThirst = ((OrganicDog) mapEntry.getValue()).getThirst();
                int petWaste = ((OrganicDog) mapEntry.getValue()).getWaste();
                int petHealth = mapEntry.getValue().getHealth();
                int petHappiness = mapEntry.getValue().getHappiness();
                int petCleanliness = ((OrganicDog) mapEntry.getValue()).getCageCleanliness();
                System.out.println(petName + " - Hunger: " + petHunger + " Thirst: " + petThirst + " Waste: " + petWaste + " Health: " + petHealth + " Happiness: " + petHappiness + " Cage Cleanliness: " + petCleanliness);

            } else if (mapEntry.getValue() instanceof RoboticPets) {
                String petName = mapEntry.getKey();
                int petHealth = mapEntry.getValue().getHealth();
                int petHappiness = mapEntry.getValue().getHappiness();
                int petOil = ((RoboticPets) mapEntry.getValue()).getOilLevel();
                System.out.println(petName + " - Health: " + petHealth + " Happiness: " + petHappiness + " Oil level: " + petOil);

            } else if (mapEntry.getValue() instanceof OrganicPets) {
                String petName = mapEntry.getKey();
                int petHunger = ((OrganicPets) mapEntry.getValue()).getHunger();
                int petThirst = ((OrganicPets) mapEntry.getValue()).getThirst();
                int petWaste = ((OrganicPets) mapEntry.getValue()).getWaste();
                int petHealth = mapEntry.getValue().getHealth();
                int petHappiness = mapEntry.getValue().getHappiness();
                System.out.println(petName + " - Hunger: " + petHunger + " Thirst: " + petThirst + " Waste: " + petWaste + " Health: " + petHealth + " Happiness: " + petHappiness);
            } else {

                String petName = mapEntry.getKey();
                int petHealth = mapEntry.getValue().getHealth();
                int petHappiness = mapEntry.getValue().getHappiness();
                System.out.println(petName + " - Health: " + petHealth + " Happiness: " + petHappiness);
            }
        }
    }

}
