import java.io.File;
import java.util.Scanner;
public class PetAdoptionMain {

    public static  PetAdoptionCenter petAdoptionCenter = new PetAdoptionCenter();

    public static void menu(){
        System.out.println("============================Welcome to Pet Adoption Center============================");
        System.out.println("What do you want to do?");
        System.out.println("1) Add new pet");
        System.out.println("2) Register new Adopter");
        System.out.println("3) Adopt a new pet");
        System.out.println("4) Adoption status manage");
        System.out.println("5) Save data");
        System.out.println("6) Exit");
        System.out.println("=======================================================================================");
        System.out.println();

    }

    public static void  addNewPet(Scanner scanner){
        int menuAddNewPetOption;
        boolean exit = false;
        while (!exit){
            System.out.println("============================Add new pet============================");
            System.out.println("What type of pet do you want to add? ");
            System.out.println("1) Dog");
            System.out.println("2) Cat");
            System.out.println("3) Bird");
            System.out.println("4) Exit");
            menuAddNewPetOption = scanner.nextInt();
            scanner.nextLine();
            switch (menuAddNewPetOption){
                case 1:
                    addDogPet(scanner);
                    break;
                case 2:
                    addCatPet(scanner);
                    break;
                case 3:
                    addBirdPet(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }


    }

    public static void addCatPet(Scanner scanner){
        String petId;
        String petName;
        String species = "Cat";
        int age;
        String breed;
        boolean isAdopted = false;
        System.out.println();
        System.out.println("Add Cat");
        System.out.println("Write the pet ID: ");
        petId = scanner.nextLine();
        System.out.println("Write the pet Name: ");
        petName = scanner.nextLine();
        System.out.println("Write the pet Age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write the pet breed");
        breed = scanner.nextLine();
        try{
            petAdoptionCenter.addPet(new Cat(petId,petName,species,age,breed,isAdopted));
        }catch (PetAlreadyExistException e){
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    public static void addDogPet(Scanner scanner){
        String petId;
        String petName;
        String species = "Dog";
        int age;
        String breed;
        boolean trained;
        int isTrainedAux;
        boolean isAdopted = false;
        System.out.println();
        System.out.println("Add Dog");
        System.out.println("Write the pet ID: ");
        petId = scanner.nextLine();
        System.out.println("Write the pet Name: ");
        petName = scanner.nextLine();
        System.out.println("Write the pet Age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write the pet breed");
        breed = scanner.nextLine();
        System.out.println("Is the Dog trained?   1) YES   2) NO");
        isTrainedAux = scanner.nextInt();
        scanner.nextLine();
        switch (isTrainedAux){
            case 1:
                try{
                    petAdoptionCenter.addPet(new Dog(petId,petName,species,age,breed,true,isAdopted));
                }catch (PetAlreadyExistException e){
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                break;
            case 2:
                try{
                    petAdoptionCenter.addPet(new Dog(petId,petName,species,age,breed,false,isAdopted));
                }catch (PetAlreadyExistException e){
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                break;

        }

    }

    public static void addBirdPet(Scanner scanner){
        String petId;
        String petName;
        String species = "Bird";
        int age;
        String breed;
        boolean canFly;
        int canFlyAux;
        boolean isAdopted = false;
        System.out.println();
        System.out.println("Add Bird");
        System.out.println("Write the pet ID: ");
        petId = scanner.nextLine();
        System.out.println("Write the pet Name: ");
        petName = scanner.nextLine();
        System.out.println("Write the pet Age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write the pet breed");
        breed = scanner.nextLine();
        System.out.println("(Write only numbers) Can the Bird Fly?   1) YES   2) NO ");
        canFlyAux = scanner.nextInt();
        scanner.nextLine();
        switch (canFlyAux){
            case 1:
                try{
                    petAdoptionCenter.addPet(new Bird(petId,petName,species,age,breed,true,isAdopted));
                }catch (PetAlreadyExistException e){
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                break;
            case 2:
                try{
                    petAdoptionCenter.addPet(new Bird(petId,petName,species,age,breed,false,isAdopted));
                }catch (PetAlreadyExistException e){
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                break;

        }

    }

    public static void addNewAdopter(Scanner scanner){
        String adopterId;
        String adopterName;
        String adopterContactInfo;
        System.out.println();
        System.out.println("============================Add New Adopter============================");
        System.out.println("Write the Adopter ID: ");
        adopterId = scanner.nextLine();
        System.out.println("Write the Adopter Name: ");
        adopterName = scanner.nextLine();
        System.out.println("Write the Adopter Email: ");
        adopterContactInfo = scanner.nextLine();
        try {

            petAdoptionCenter.addAdopter(new Adopter(adopterId,adopterName,adopterContactInfo));

        }catch (AdopterAlreadyExistException e){
            System.out.println(e.getMessage());
            System.out.println();
        }

    }

    public static void adoptNewPet(Scanner scanner){
        String adopterId;
        String petId;
        System.out.println("============================Adopt New Pet============================");
        petAdoptionCenter.showAdopters();
        System.out.println("Write the ID of the Adopter who want to adopt a new pet");
        adopterId = scanner.nextLine();
        petAdoptionCenter.showAvailablePets();
        System.out.println("Write the ID of the pet you want to adopt: ");
        petId = scanner.nextLine();

        try {
            petAdoptionCenter.adoptPet(adopterId,petId);
        }catch (AdopterNotFoundException | PetNotFoundException | PetAdoptedException e){
            System.out.println(e.getMessage());
            System.out.println();
        }


    }

    public static void showPetInfo(Scanner scanner){
        String petInfo;
        System.out.println();
        System.out.println("============================Show Pet Information============================");
        System.out.println("Write the ID of the pet you want to see the information: ");
        petInfo = scanner.nextLine();
        try {
            petAdoptionCenter.showPetInfo(petInfo);
        }catch (PetNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public static void showAdopterInfo(Scanner scanner){
        String adopterInfo;
        System.out.println();
        System.out.println("============================Show Adopter Information============================");
        System.out.println("Write the ID of the Adopter you want to see the information: ");
        adopterInfo = scanner.nextLine();
        try {
            petAdoptionCenter.showAdopterInfo(adopterInfo);
        }catch (AdopterNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showAdopterPets(Scanner scanner){
        String adopterInfo;
        System.out.println();
        System.out.println("============================Show Adopter Information============================");
        System.out.println("Write the ID of the Adopter you want to see the information: ");
        adopterInfo = scanner.nextLine();
        try {
            petAdoptionCenter.showAdopterPets(adopterInfo);
        }catch (AdopterNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println("=================================================================================");
    }

    public static void showAdopterList(){
        petAdoptionCenter.showAdopters();
    }

    public static void showPetList(){
        petAdoptionCenter.showPetsList();
    }

    public static void showInformation(Scanner scanner){
        int option;
        boolean exit = false;
        while (!exit){
            System.out.println();
            System.out.println("============================Show information============================");
            System.out.println("What information you want to know?");
            System.out.println("1) Adopter Information");
            System.out.println("2) Show Adopter Pets");
            System.out.println("3) Show Pet Information");
            System.out.println("4) Show Adopter List");
            System.out.println("5) Show Pet List");
            System.out.println("6) Exit");
            System.out.println("=========================================================================");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    showAdopterInfo(scanner);
                    break;
                case 2:
                    showAdopterPets(scanner);
                    break;
                case 3:
                    showPetInfo(scanner);
                    break;
                case 4:
                    showAdopterList();
                    break;
                case 5:
                    showPetList();
                    break;
                case 6:
                    exit = true;
                    break;

            }
        }

    }

    public static void saveData(){
        petAdoptionCenter.saveData();
    }

    public static void main(String[] args) {
        String petsFile = "Capstone_Project_Pet_Adoption_Center/src/Pets.txt";
        String adopterFile = "Capstone_Project_Pet_Adoption_Center/src/Adopters.txt";
        File petsFileAux = new File(petsFile);
        File adoptersFileAux = new File(adopterFile);

        if((!petsFileAux.exists() && adoptersFileAux.exists()) || (petsFileAux.exists() && !adoptersFileAux.exists())) {
            System.out.println("Error al cargar los archivos .txt , elimine los archivos Pets.txt , Adopters.txt y vuelva a intentar");
        }
        else if (!petsFileAux.exists() && !adoptersFileAux.exists()){
            Scanner scanner = new Scanner(System.in);
            int menuOption;
            boolean exit = false;
            while (!exit){
                menu();
                menuOption = scanner.nextInt();
                scanner.nextLine();
                switch (menuOption){
                    case 1:
                        addNewPet(scanner);
                        break;
                    case 2:
                        addNewAdopter(scanner);
                        break;
                    case 3:
                        adoptNewPet(scanner);
                        break;
                    case 4:
                        showInformation(scanner);
                        break;
                    case 5:
                        saveData();
                        break;
                    case 6:
                        exit = true;
                        break;
                }
            }

        }
        else{
            System.out.println("Data loaded");
            petAdoptionCenter.loadData();
            Scanner scanner = new Scanner(System.in);
            int menuOption;
            boolean exit = false;
            while (!exit){
                menu();
                menuOption = scanner.nextInt();
                scanner.nextLine();

                switch (menuOption){
                    case 1:
                        addNewPet(scanner);
                        break;
                    case 2:
                        addNewAdopter(scanner);
                        break;
                    case 3:
                        adoptNewPet(scanner);
                        break;
                    case 4:
                        showInformation(scanner);
                        break;
                    case 5:
                        saveData();
                        break;
                    case 6:
                        exit = true;
                        System.out.println("Exiting");
                        break;
                }
            }

        }


    }
}
