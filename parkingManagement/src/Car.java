public class Car extends Vehicle{
    private boolean isElectric;
    static int carHourFee = 30000;
    Car(String plateNumber, String ownerName, int entryHour, boolean isElectric){
        super(plateNumber, ownerName, entryHour);
        this.isElectric = isElectric;
    }

    @Override
    public double calculateFee(int exitHour){
        double fee = this.calculateTime(exitHour) * carHourFee;
        if (this.isElectric){
            fee *= 0.8;
        }
        return fee;
    }
}
