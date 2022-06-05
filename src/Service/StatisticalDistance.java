package Service;

import Entity.DriverAssignment;
import Main.MainRun;

public class StatisticalDistance {
    public static int distance(DriverAssignment driverAssignment){
        int sum =0;
        for (int i = 0; i < driverAssignment.getBusLineDetails().size(); i++) {
            sum += (driverAssignment.getBusLineDetails().get(i).getBusLine().getDistance() * driverAssignment.getBusLineDetails().get(i).getBusLine().getNumberStop() * driverAssignment.getBusLineDetails().get(i).getQuantity());
        }
        return sum;
    }
    public void statisticalDistance(){
        for (DriverAssignment a : MainRun.driverAssignments) {
            System.out.println(a.getDriver().getName() + " " + distance(a));
        }
    }
}
