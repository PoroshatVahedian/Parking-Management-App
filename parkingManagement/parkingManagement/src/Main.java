import java.util.Scanner;
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome! Please Enter the name of parking:");
    String parkingName = input.nextLine();
    System.out.println("Please enter the capacity of parking:");
    short parkingCapacity = input.nextShort();
    Parking parking = new Parking(parkingName, parkingCapacity);
    showMenu:
    while (true){
        System.out.println("""
            ~~~~~~~~~ PARKING MANAGEMENT SYSTEM ~~~~~~~~~
            # Enter 1 to add a car
            # Enter 2 to add a motorcycle
            # Enter 3 to remove a vehicle
            # Enter 4 to search a vehicle 
            # Enter 5 to show vehicles
            # Enter 6 to show available spaces
            # Enter 7 to show parking status
            # Enter 0 to exit
            """);

        System.out.print("Please enter your choice:");
        short userChoice = input.nextShort();

        switch (userChoice){
            case 1:
                input.nextLine();

                System.out.println("Enter the plate number:");
                String carPlate = input.nextLine();

                System.out.println("Enter the name of owner:");
                String carOwner = input.nextLine();

                System.out.println("Enter entry hour:");
                int entryHour = input.nextInt();

                System.out.println("Is the car electric? (y/n):");
                char carType = input.next().charAt(0);

                boolean isElectric = false;

                if (carType == 'y')
                    isElectric = true;
                else if (carType == 'n')
                    isElectric = false;

                Vehicle newCar = new Car(carPlate, carOwner, entryHour, isElectric);
                parking.addVehicle(newCar);
                Parking.carsNum++;
                break;

            case 2:
                input.nextLine();

                System.out.println("Enter the plate number:");
                String motorPlate = input.nextLine();

                System.out.println("Enter the name owner:");
                String motorOwner = input.nextLine();

                System.out.println("Enter entry hour:");
                int motorEntryHour = input.nextInt();

                Vehicle newMotor = new Motorcycle(motorPlate, motorOwner, motorEntryHour);
                parking.addVehicle(newMotor);
                Parking.motorsNum++;

                break;

            case 3: {
                    input.nextLine();

                    System.out.println("Enter the plate number:");
                    String plate = input.nextLine();

                    System.out.println("Enter exit hour:");
                    int exitHour = input.nextInt();

                    parking.exit(plate, exitHour);
                    break;
                }


            case 4: {
                input.nextLine();
                System.out.println("Enter the plate number:");
                String plate = input.nextLine();

                Vehicle foundVehicle = parking.findVehicle(plate);
                System.out.println(foundVehicle);
                break;
            }

            case 5:
                parking.showVehicles();
                break;

            case 6:
                System.out.println(parking.getAvailableSpaces());
                break;

            case 7:
                parking.showParkingStatus();
                break;

            case 0:
                System.out.println("Hope to see you again :)");
                break showMenu;

            default:
                System.out.println("!!!Invalid input!!!");

        }
    }


}
