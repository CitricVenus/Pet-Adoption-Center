import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Adopter {
    private String adopterId;
    private String adopterName;
    private String adopterContactInfo;
    private List<Pet> adoptedPetsArrayList = new ArrayList<>();

    public Adopter(String adopterId, String adopterName, String adopterContactInfo){
        this.adopterId = adopterId;
        this.adopterName = adopterName;
        this.adopterContactInfo = adopterContactInfo;
    }

    public String getAdopterId() {
        return this.adopterId;
    }

    public void setAdopterId(String adopterId) {
        this.adopterId = adopterId;
    }

    public String getAdopterName() {
        return this.adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getAdopterContactInfo() {
        return this.adopterContactInfo;
    }

    public void setAdopterContactInfo(String adopterContactInfo) {
        this.adopterContactInfo = adopterContactInfo;
    }

    public void addPet(Pet pet) {
        this.adoptedPetsArrayList.add(pet);
    }

    public String getAdoptedInfo(){
        return "Adopter ID: "+this.adopterId+"\n"+"Name: "+this.adopterName+"\n"+"Contact: "+this.adopterContactInfo+"\n";
    }

    public void showPetsAdopted(){
        if (adoptedPetsArrayList.isEmpty()){
            System.out.println("You haven't adopted a pet");
        }else{
            System.out.println("Adopted pets: ");
            for(Pet pets : adoptedPetsArrayList){
                System.out.println("Pet name: "+pets.getPetName()+", Pet Specie: "+pets.getSpecies());
            }
        }
    }

    public List<Pet> getAdoptedPetsList(){
        return adoptedPetsArrayList;
    }


}
