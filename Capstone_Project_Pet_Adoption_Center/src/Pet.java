import java.util.SortedMap;

public abstract class Pet {
    protected String petId;
    protected String petName;
    protected String species;
    protected int age;
    protected boolean isAdopted;
    protected String breed;

    public Pet (String petId , String petName, String species, int age, String breed, boolean isAdopted){
        this.petId = petId;
        this.petName =petName;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.isAdopted = false;
    }


    public String getPetId() {
        return this.petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getAdoptionStatus() {
        return this.isAdopted;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setAdoptionStatus(boolean adoptionStatus) {
        this.isAdopted = adoptionStatus;
    }

    public abstract String getPetInformation();

    public String adoptionStatusToString(){
        return this.isAdopted ? "This pet is already adopted" : "Available to adopt";
    }
}
