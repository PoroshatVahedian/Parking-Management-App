public class Parking {
    private String name;
    private short capacity;
    private Vehicle[] vehicles;
    static short occupied;
    static short carsNum;
    static short motorsNum;


    Parking(String name, short capacity){
        this.name = name;
        this.capacity = capacity;
        this.vehicles = new Vehicle[capacity];
        occupied = 0;
        carsNum = 0;
        motorsNum = 0;
    }
    public void addVehicle(Vehicle vehicle) {
        if (this.capacity != 0) {
            for (int i = 0; i < this.vehicles.length; i++) {
                if (vehicles[i] == null) {
                    vehicles[i] = vehicle;
                    occupied++;
                    break;
                }

                if (vehicle.getPlateNumber().equals(vehicles[i].getPlateNumber())) {
                    System.out.println("!!!This plate number already exists in the parking!!!");
                    break;
                }
            }
        }
        else {
            System.out.println("!!!Can not add the vehicle, Not enough capacity!!!");
        }
    }

    public Vehicle findVehicle(String plateNumber){
        for (int i = 0; i < occupied; i++) {
            if (plateNumber.equals(vehicles[i].getPlateNumber()))
                return vehicles[i];
        }
        return null;
    }

    public void exit(String plateNumber, int exitHour){
        int i = 0;
        boolean found = false;
        for (int j = 0; j < occupied; j++) {
            if (vehicles[j].getPlateNumber().equals(plateNumber)){
                int duration = vehicles[j].calculateTime(exitHour);
                double fee = vehicles[j].calculateFee(duration);
                vehicles[j].showInfo(duration, fee);
                i = j;
                found = true;
                break;
            }
        }
        if (found) {
            for (int k = i; k < vehicles.length - 1; k++) {
                vehicles[k] = vehicles[k + 1];
            }
            vehicles[vehicles.length - 1] = null;
            this.capacity++;
        }
        else System.out.println("!!!This vehicle does not exist!!!");
    }

    public void showVehicles(){
        for (int i = 0; i < occupied; i++) {
            if ( vehicles[i] != null){
                System.out.println(i+1 + ") ");
                vehicles[i].showInfo();
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }

    public int getAvailableSpaces(){
        return (this.capacity - occupied);
    }

    public void showParkingStatus(){
        System.out.println("Parking: " + this.name + "\n" + "Capacity: " + this.capacity + "\n" + "Occopied: " + occupied + "\n" +
                "Available: " + this.getAvailableSpaces() + "\n" + "Cars: " + carsNum + "\n" + "Motorcycles: " + motorsNum);
    }
}
