public class Motorcycle extends Vehicle{
    static int carHourFee = 15000;

    Motorcycle(String plateNumber, String ownerName, int entryHour) {
        super(plateNumber, ownerName, entryHour);
    }

    @Override
    public double calculateFee(int exitHour){
        double fee = this.calculateTime(exitHour) * carHourFee;
        return fee;
    }
}
