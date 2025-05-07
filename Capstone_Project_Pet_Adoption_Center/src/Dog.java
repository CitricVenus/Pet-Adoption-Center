public class Dog extends Pet {
    private boolean trained;

    public Dog(String petId, String petName, String species, int age, String breed, boolean trained, boolean isAdopted) {
        super(petId, petName, "Dog", age, breed, isAdopted);
        this.trained = trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public boolean isTrained() {
        return this.trained;
    }

    @Override
    public String getPetInformation() {
        if (isAdopted){
            if (trained){
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Is trained? : Yes \n" + "Adopted status: Adopted \n";
            }else{
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Is trained? : No \n" + "Adopted status: Adopted \n";
            }
        }else{
            if (trained){
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Is trained? : Yes \n" + "Adopted status: Not Adopted \n";
            }else{
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Is trained? : No \n" + "Adopted status: Not Adopted \n";
            }
        }
    }
}
