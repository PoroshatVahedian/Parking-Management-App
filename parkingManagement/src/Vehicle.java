public class Vehicle {
    private String plateNumber;
    private String ownerName;
    private int entryHour;

    Vehicle(String plateNumber, String ownerName, int entryHour){
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
        this.entryHour = entryHour;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double calculateFee(int duration){
        return 0;
    }


    public int calculateTime(int exitHour){
        int time;
        if (exitHour < this.entryHour) {
            exitHour += 24;
        }
        time = exitHour - this.entryHour;
        return time;
    }

    public void showInfo(int duration, double fee){
        System.out.println("Owner Name: " + this.ownerName + "\n" + "Plate number: " + this.plateNumber +
                "\n" + "Duration: " + duration + "\n" + "Fee: " + fee);
    }

    public void showInfo(){
        System.out.println("Owner Name: " + this.ownerName + "\n" + "Plate number: " + this.plateNumber );
    }
}

