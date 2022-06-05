package Entity;

import java.io.Serializable;
import java.util.List;

public class DriverAssignment implements Serializable {
    private Driver driver;
    private List<BusLineDetail> busLineDetails;

    public DriverAssignment(Driver driver, List<BusLineDetail> busLineDetails) {
        this.driver = driver;
        this.busLineDetails = busLineDetails;
    }

    public DriverAssignment() {
    }

    @Override
    public String toString() {
        return "DriverAssignment{" +
                "driver=" + driver +
                ", busLineDetails=" + busLineDetails +
                '}';
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<BusLineDetail> getBusLineDetails() {
        return busLineDetails;
    }

    public void setBusLineDetails(List<BusLineDetail> busLineDetails) {
        this.busLineDetails = busLineDetails;
    }
}
