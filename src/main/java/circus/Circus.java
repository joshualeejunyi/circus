package circus;

import java.util.ArrayList;
import java.util.Arrays;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Elephant;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a: animalArrayList) {
            System.out.println(a);
        }
    }

    private static void printCircusSize(ArrayList<Animal> animalArrayList) {
        System.out.printf("Number of animals in Circus: %d\n", animalArrayList.size());
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in Circus " + animals.length);
        // makeAnimalsTalk();

        ArrayList<Animal> animalArrayList = new ArrayList<Animal>(Arrays.asList(animals));
        printAllAnimals(animalArrayList);
        printCircusSize(animalArrayList);

        Elephant strongOne = new Elephant("StrongOne"); 
        Parrot andy = new Parrot("Andy");

        animalArrayList.add(new Duck("Louie"));
        animalArrayList.add(strongOne);
        animalArrayList.add(andy);

        printAllAnimals(animalArrayList);
        printCircusSize(animalArrayList);


        System.out.println("Before sort...");
        printAllAnimals(animalArrayList);
        printCircusSize(animalArrayList);
        System.out.printf("Strong One is at position: %d\n", animalArrayList.indexOf(strongOne));

        System.out.println("After sort...");
        animalArrayList.sort(Animal.AnimalNameComparator);
        printAllAnimals(animalArrayList);
        printCircusSize(animalArrayList);

        System.out.printf("Strong One is at position: %d\n", animalArrayList.indexOf(strongOne));


        // System.out.println("Total value of animals " + calculateAssetValue(animals));
        // System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }
}
