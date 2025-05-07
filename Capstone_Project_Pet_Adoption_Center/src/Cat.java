public class Cat extends Pet{

    public Cat(String petId, String petName, String species, int age, String breed, boolean isAdopted) {
        super(petId, petName, "Cat", age, breed, isAdopted);
    }

    @Override
    public String getPetInformation() {
        if (isAdopted){
            return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n" + "Adopted status: Adopted \n";
        }else{
            return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n" + "Adopted status: Not Adopted \n";
        }
    }

}
