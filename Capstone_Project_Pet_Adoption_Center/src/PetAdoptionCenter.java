import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PetAdoptionCenter {
    private HashMap<String,Pet> petHashMap = new HashMap<>();
    private HashMap<String,Adopter> adopterHashMap =new HashMap<>();
    private FileManager fileManager = new FileManager();

    public PetAdoptionCenter(){}

    public void addPet(Pet pet)throws PetAlreadyExistException{
        if (!petHashMap.containsKey(pet.getPetId())){
            petHashMap.put(pet.getPetId(),pet);
            System.out.println();
            System.out.println("Pet added");
            System.out.println();
        }else{
            throw new PetAlreadyExistException("This pet ID already exist: "+pet.getPetId() + ", Try again");
        }

    }

    public void addAdopter(Adopter adopter)throws AdopterAlreadyExistException{
        if (!adopterHashMap.containsKey(adopter.getAdopterId())){
            adopterHashMap.put(adopter.getAdopterId(),adopter);
            System.out.println("Adopter added");
        }else {
            throw new AdopterAlreadyExistException("This adopter ID already exist: " + adopter.getAdopterId() + ", Try again");
        }

    }

    public void showAvailablePets(){
        ArrayList<Pet> availablePets = new ArrayList<>();
        if (petHashMap.isEmpty()){
            System.out.println("No pets to show");
        }
        for (Pet pet : petHashMap.values()){
            if (!pet.getAdoptionStatus()){
                availablePets.add(pet);
            }
        }
        if (!availablePets.isEmpty()){
            System.out.println("============================Available pets============================");
            for (Pet pets : availablePets){
                System.out.println(pets.getPetInformation());
            }
            System.out.println("=======================================================================");
        }else {
            System.out.println("There are no available pets to adopt");
        }
    }

    public void adoptPet(String adopterId,String petId) throws AdopterNotFoundException,PetNotFoundException,PetAdoptedException{
        Adopter adopter = adopterHashMap.get(adopterId);
        Pet pet = petHashMap.get(petId);

        if (adopter == null){throw new AdopterNotFoundException("Adopter doesn't exist, Try again");}
        if (pet == null){throw new PetNotFoundException("Pet doesn't exist, Try again");}
        if (pet. getAdoptionStatus()){throw new PetAdoptedException("This pet is already adopted, Try again");}

        pet.setAdoptionStatus(true);
        adopter.addPet(pet);
        System.out.println(pet.getPetName()+" Was adopted by "+ adopter.getAdopterName() + ", The adoption was successful");

    }

    public void showAdopters(){
        System.out.println();
        System.out.println("============================List of Adopters============================");
        for(Adopter adopter : adopterHashMap.values()){
            System.out.println("Adopter ID: "+adopter.getAdopterId() + ", Adopter Name: "+adopter.getAdopterName() );
        }
        System.out.println("=========================================================================");
    }

    public void showAdopterInfo(String adopterId) throws AdopterNotFoundException{
        Adopter adopter = adopterHashMap.get(adopterId);
        if (adopter == null){
            throw new AdopterNotFoundException("Adopter doesn't exist, Try again");}
        else{
            System.out.println(adopter.getAdoptedInfo());
        }

    }

    public void showAdopterPets(String adopterId) throws AdopterNotFoundException{
        Adopter adopter = adopterHashMap.get(adopterId);
        if (adopter == null){
            throw new AdopterNotFoundException("Adopter doesn't exist, Try again");}
        else{
            adopter.showPetsAdopted();
        }

    }

    public void showPetInfo(String petId) throws  PetNotFoundException{
        Pet pet = petHashMap.get(petId);
        if (pet == null){throw new PetNotFoundException("Pet doesn't exist, Try again");}
        else{
            System.out.println(pet.getPetInformation());
        }
    }

    public void showPetsList(){
        System.out.println();
        System.out.println("============================List of Pets============================");
        for(Pet pet : petHashMap.values()){
            System.out.println(pet.getPetInformation());
        }
        System.out.println("====================================================================");
    }

    public void saveData(){

        fileManager.savePets(petHashMap);
        fileManager.saveAdopters(adopterHashMap);
    }

    public void loadData(){
        this.petHashMap =  fileManager.loadPetsFile();
        this.adopterHashMap = fileManager.loadAdoptersFile(this.petHashMap);

    }

}
