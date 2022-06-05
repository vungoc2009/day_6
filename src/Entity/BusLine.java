package Entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusLine  implements Serializable {
    public static int autoId = -1;
    private int id;
    private double distance;
    private int numberStop;

    public BusLine(){
        if(autoId == -1){
            autoId = 100;
            id = autoId;
            return;
        }
        this.id = autoId;
    }

    public BusLine(int id, double distance, int numberStop) {
        this.id = id;
        this.distance = distance;
        this.numberStop = numberStop;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getNumberStop() {
        return numberStop;
    }

    public void setNumberStop(int numberStop) {
        this.numberStop = numberStop;
    }
    public void inputBusLine(){
        this.id = BusLine.autoId++;
        do{
            try {
                System.out.print("Nhập thông khoảng cách: ");
                this.distance = new Scanner(System.in).nextDouble();
                if(this.distance > 0)break;
            }catch (Exception e){
                System.out.println("Nhập khoảng cách sai");
            }
        }while (true);
        do{
            try {
                System.out.print("Nhập số điểm dừng: ");
                this.numberStop = new Scanner(System.in).nextInt();
                if (this.numberStop > 0)break;
            }catch (InputMismatchException e){
                System.out.println("nhập sai số điểm dừng");
            }
        }while (true);
    }

    @Override
    public String toString() {
        return "BusLine{" +
                "id=" + id +
                ", distance=" + distance +
                ", numberStop=" + numberStop +
                '}';
    }
}
