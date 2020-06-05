package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    VirtualPet martin = new VirtualPet("Martin", "Cat", 12, 7, 5);
    VirtualPet oliver = new VirtualPet("Oliver", "Cat", 4, 3, 7);

    private Map<String, VirtualPet> pets = new HashMap<>();

    public void addFirstPets() {
        pets.put(martin.getPetName(), martin);
        pets.put(oliver.getPetName(), oliver);
    }

    public void getAllPets() {
        System.out.println(" Name\t\t|\tType\t|\tHunger\t|\tThirst\t|\tHappiness\t|");
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            System.out.println(pet.getPetName() + "\t\t|\t" + pet.getPetDescription() + "\t\t|\t" + pet.getHunger() + "\t\t|\t" + pet.getThirst() + "\t\t|\t" + pet.getHappiness() + "\t\t\t|\t");
        }
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
            VirtualPet pet = mapEntry.getValue();
            pet.feedPet();
        }
    }

    public void waterAllPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            pet.waterPet();
        }
    }

    public void playWithOnePet(String requestedPetName) {
        VirtualPet pet = getVirtualPet(requestedPetName);
        pet.playWithPet();
    }

    public void tickAllPets() {
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            pet.tick();
        }
    }

    protected boolean checkHealthOfAllPets() {
        boolean checkHealthOfAllPets = true;
        for (Map.Entry<String, VirtualPet> mapEntry : pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            if (pet.arePetsHealthy()) {
                checkHealthOfAllPets = false;
                break;

            }
        }
        return checkHealthOfAllPets;

    }


}
