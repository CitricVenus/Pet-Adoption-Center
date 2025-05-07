import com.sun.source.tree.TryTree;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManager {

    public FileManager(){}

    public void savePets(Map<String,Pet> pets){
        try{
           BufferedWriter writerFile = new BufferedWriter(new FileWriter("Capstone_Project_Pet_Adoption_Center/src/Pets.txt"));
           for (Pet pet : pets.values()){
               if (pet.getSpecies().equals("Cat")){
                   Cat cat = (Cat)pet;
                   writerFile.write(cat.getPetId()+ "," + cat.getPetName() + "," + cat.getSpecies() + "," + cat.getAge() + "," + cat.getBreed() + "," + cat.getAdoptionStatus());
                   writerFile.newLine();
               } else if (pet.getSpecies().equals("Dog")) {
                   Dog dog = (Dog)pet;
                   writerFile.write(dog.getPetId()+ "," + dog.getPetName() + "," + dog.getSpecies() + "," + dog.getAge() + "," + dog.getBreed() + "," + dog.isTrained()+ "," +dog.getAdoptionStatus());
                   writerFile.newLine();
               }else if (pet.getSpecies().equals("Bird")){
                   Bird bird = (Bird) pet;
                   writerFile.write(bird.getPetId()+ "," + bird.getPetName() + "," + bird.getSpecies() + "," + bird.getAge() + "," + bird.getBreed() + "," + bird.getCanFly()+ "," +bird.getAdoptionStatus());
                   writerFile.newLine();
               }

           }
            writerFile.close();
        }catch (IOException e){
            System.out.println("Error saving data in file\n" + e.getMessage());
        }
        System.out.println("Mascotas guardadas en: Capstone Project Pet Adoption Center/src/Pets.txt");

    }

    public void saveAdopters(Map<String,Adopter> adopters){
        try{
            BufferedWriter writerFile = new BufferedWriter(new FileWriter("Capstone_Project_Pet_Adoption_Center/src/Adopters.txt"));
            for (Adopter adopter : adopters.values()){
                StringBuilder line = new StringBuilder(adopter.getAdopterId() + "," +
                        adopter.getAdopterName() + "," + adopter.getAdopterContactInfo() + ",");

                List<Pet> petsAdopted = adopter.getAdoptedPetsList();
                for (int i = 0 ; i < petsAdopted.size(); i++){
                    line.append(petsAdopted.get(i).getPetId());
                    if (i < petsAdopted.size() -1){
                        line.append("|");
                    }
                }
                writerFile.write(line.toString());
                writerFile.newLine();
            }
            writerFile.close();
        }catch (IOException e){
            System.out.println("Error saving data in file\n" + e.getMessage());
        }
        System.out.println("Mascotas guardadas en: Capstone Project Pet Adoption Center/src/Adopters.txt");

    }

    public HashMap<String,Pet> loadPetsFile(){
        HashMap<String,Pet> pets = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Capstone_Project_Pet_Adoption_Center/src/Pets.txt"));
            String line;
            while ((line = reader.readLine()) != null){

                String[] parts = line.split(",");

                if (parts.length == 6 && parts[2].equals("Cat")){
                    String id = parts[0];
                    String name = parts[1];
                    String species = parts[2];
                    int age = Integer.parseInt(parts[3]);
                    String breed = parts[4];
                    boolean adopted = Boolean.parseBoolean(parts[5]);
                    Pet pet;
                    pet = new Cat(id,name,species,age,breed,adopted);
                    if (adopted) pet.setAdoptionStatus(true);
                    pets.put(id, pet);

                }
                else if (parts.length == 7 && parts[2].equals("Dog")){
                    String id = parts[0];
                    String name = parts[1];
                    String species = parts[2];
                    int age = Integer.parseInt(parts[3]);
                    String breed = parts[4];
                    boolean trained = Boolean.parseBoolean(parts[5]);
                    boolean adopted = Boolean.parseBoolean(parts[6]);
                    Pet pet;
                    pet = new Dog(id,name,species,age,breed,trained,adopted);
                    if (adopted) pet.setAdoptionStatus(true);
                    pets.put(id, pet);

                } else if (parts.length == 7 && parts[2].equals("Bird")) {
                    String id = parts[0];
                    String name = parts[1];
                    String species = parts[2];
                    int age = Integer.parseInt(parts[3]);
                    String breed = parts[4];
                    boolean canFly = Boolean.parseBoolean(parts[5]);
                    boolean adopted = Boolean.parseBoolean(parts[6]);
                    Pet pet;
                    pet = new Bird(id,name,species,age,breed,canFly,adopted);
                    if (adopted) pet.setAdoptionStatus(true);
                    pets.put(id, pet);
                }
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Error trying to load Pets.txt" + e.getMessage());
        }
        return pets;
    }

    public  HashMap<String,Adopter> loadAdoptersFile(Map<String,Pet> pets){
        HashMap<String,Adopter> adopters = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Capstone_Project_Pet_Adoption_Center/src/Adopters.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",", 4);
                String id = parts[0];
                String name = parts[1];
                String contact = parts[2];
                String petIds = parts.length > 3 ? parts[3] : "";

                Adopter adopter = new Adopter(id,name,contact);
                if (!petIds.isEmpty()){
                    String [] idPets = petIds.split("\\|");
                    for (String petId : idPets){
                        Pet pet = pets.get(petId);
                        if (pet != null){
                            adopter.addPet(pet);
                            pet.setAdoptionStatus(true);
                        }
                    }

                }
                adopters.put(id,adopter);
            }
            reader.close();
        }catch (IOException e){
            System.out.println("Error reading Adopters.txt" + e.getMessage());
        }
        return adopters;
    }
}
