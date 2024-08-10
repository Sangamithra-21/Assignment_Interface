package Assignment_14_Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface RemoteControlCar {
    void drive();
    int getDistanceTravelled();
}
class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int distanceTravelled=0;
    public void drive()
    {
        distanceTravelled+=20;
    }
    public int getDistanceTravelled(){
        return distanceTravelled;
    }
}
class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceTravelled = 0;
    private int numberOfVictories;

    public void drive() {
        distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }


    public int getNumberOfVictories() {
        return numberOfVictories;
    }


    public void setNumberOfVictories(int victories) {
        this.numberOfVictories = victories;
    }


    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(otherCar.getNumberOfVictories(), this.numberOfVictories);
    }

}

class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        List<ProductionRemoteControlCar> s=new ArrayList<>(cars);
        Collections.sort(s);
        return s;
    }
}

