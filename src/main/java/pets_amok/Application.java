package pets_amok;

import java.util.Scanner;

public class Application {
    static VirtualPetShelter virtualPetShelter = new VirtualPetShelter();

    public static void main(String[] args) {

        OrganicDog organicDog1 = new OrganicDog("Martin", "Doggo", 5, 7, 8, 5, 17, 12);
        OrganicCat organicCat1 = new OrganicCat("Ollie", "kitty", 9, 9, 3, 15, 9);
        RoboticPets roboPet1 = new RoboticPets("Leroy", "Robo dog", 16, 13, 16);
        virtualPetShelter.addPet(organicCat1);
        virtualPetShelter.addPet(organicDog1);
        virtualPetShelter.addPet(roboPet1);

        displayIntroduction();
        displayAllPets();
        gameLoop();


    }

    public static void displayIntroduction() {
        System.out.println("");
        System.out.println("Welcome to Derek's Pet Shelter!");
        System.out.println("");

    }

    public static void displayAllPets() {
        System.out.println("Here are the pets in the shelter currently: ");
        virtualPetShelter.getPetHealthStatus();

    }

    public static void gameLoop() {
        while (virtualPetShelter.checkHealthOfAllPets()) {
            Integer userAction = askUserForAction();
            performActionOnPet(userAction);
            System.out.println("");
            displayAllPets();

        }
        System.out.println("");
        System.out.println("One of your pets was unhappy and ran away! You lose!");

    }

    public static Integer askUserForAction() {
        System.out.println("");
        System.out.println("What would you like to do with the pets?");
        System.out.println("1. Feed the pets");
        System.out.println("2. Water the pets");
        System.out.println("3. Play with an individual pet");
        System.out.println("4. Bring in a new pet");
        System.out.println("5. Adopt a pet");
        System.out.println("6. Leave the shelter");
        System.out.println("7. Walk the dogs");
        System.out.println("8. Clean the dog cages");
        System.out.println("9. Oil the robotic pets");

        Scanner scanner = new Scanner(System.in);
        int userAction = scanner.nextInt();
        return userAction;
    }

    public static void performActionOnPet(Integer userAction) {
        if (userAction.equals(1)) {
            virtualPetShelter.feedAllPets();
            System.out.println("You just fed all the pets");
        } else if (userAction.equals(2)) {
            virtualPetShelter.waterAllPets();
            System.out.println("You just watered all the pets");
        } else if (userAction.equals(3)) {
            System.out.println("Which pet would you like to play with?");
            String petToPlayWith = askUserWhichPetToPlayWith();
            virtualPetShelter.playWithOnePet(petToPlayWith);
            System.out.println("You played with " + petToPlayWith);
        } else if (userAction.equals(4)) {
            VirtualPet petToBeAdded = askUserForPetInfo();
            virtualPetShelter.addPet(petToBeAdded);
        } else if (userAction.equals(5)) {
            System.out.println("Which pet would you like to be adopted?");
            String petToBeAdopted = askUserWhichPetToPlayWith();
            virtualPetShelter.removePet(petToBeAdopted);
            System.out.println(petToBeAdopted + " has been adopted!");
        } else if (userAction.equals(6)) {
            System.out.println("You have left Derek's Pet Shelter.");
            System.exit(0);
        } else if (userAction.equals(7)) {
            virtualPetShelter.walkAllDogs();
            System.out.println("You just walked all the dogs!");
        } else if (userAction.equals(8)) {
            virtualPetShelter.cleanAllDogsCages();
            System.out.println("You just cleaned all the dogs cages");
        } else if (userAction.equals(9)) {
            virtualPetShelter.oilRoboticPets();
            System.out.println("You just oiled the robotic pets");
        }
        virtualPetShelter.tickAllPets();
    }

    public static String askUserWhichPetToPlayWith() {
        virtualPetShelter.printNamesAndDescriptions();
        Scanner scanner = new Scanner(System.in);
        String userSelection = scanner.nextLine();
        return userSelection;

    }

    public static VirtualPet askUserForPetInfo() {
        System.out.println("What is the name of the new pet?");
        Scanner scanner = new Scanner(System.in);
        String newPetName = scanner.nextLine();

        System.out.println("What kind of animal is it?");
        Scanner scanner1 = new Scanner(System.in);
        String newPetType = scanner1.nextLine();

        VirtualPet newPet = new VirtualPet(newPetName, newPetType, 10, 10);
        return newPet;
    }


}
