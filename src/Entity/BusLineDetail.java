package Entity;

import java.io.Serializable;

public class BusLineDetail implements Serializable {
    private BusLine busLine;
    private int quantity;


    public BusLineDetail(BusLine busLine, int quantity) {
        this.busLine = busLine;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BusLineDetail{" +
                "busLine=" + busLine +
                ", quantity=" + quantity +
                '}';
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
