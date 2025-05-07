public class Bird extends Pet{
    private boolean canFly;

    public Bird(String petId, String petName, String species, int age, String breed, boolean canFly, boolean isAdopted) {
        super(petId, petName, "Bird", age, breed, isAdopted);
        this.canFly = canFly;
    }


    public boolean getCanFly() {
        return this.canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    @Override
    public String getPetInformation() {
        if (canFly){
            if (isAdopted){
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Can fly? : Yes \n" + "Adopted status: Adopted \n";
            }else{
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Can fly? : Yes \n" + "Adopted status: Not Adopted \n";
            }
        }else {
            if (isAdopted){
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Can fly? : No \n" + "Adopted status: Adopted \n";
            }else{
                return "Pet ID: " +this.petId+"\n"+"Name: "+this.petName+"\n"+"Specie: "+this.species+"\n"+"Age: "+this.age+"\n"+"Breed: "+this.breed+"\n"+"Can fly? : No \n" + "Adopted status: Not Adopted \n";
            }
        }
    }
}
