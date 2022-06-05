package Service;

import Entity.DriverAssignment;
import Main.MainRun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort {
    public void sort() {
        int option =0;
        do{
            try{
                System.out.println("nhập lựa chon");
                System.out.println("1: sắp xếp theo tên");
                System.out.println("2: sắp xếp theo tuyến trong ngày");
                option = new Scanner(System.in).nextInt();
                if(option > 0 && option < 3){
                    break;
                }
            }catch ( Exception e){
                System.out.println("nhập lựa chọn");
            }
        }while (true);
        switch (option){
            case 1:
                for (int i = 0; i < MainRun.driverAssignments.size(); i++) {
                    for (int j = i+1; j < MainRun.driverAssignments.size(); j++) {
                        if(MainRun.driverAssignments.get(i).getDriver().getName().compareTo(MainRun.driverAssignments.get(j).getDriver().getName())>0){
                            DriverAssignment driverAssignment = MainRun.driverAssignments.get(i);
                            MainRun.driverAssignments.set(i, MainRun.driverAssignments.get(j));
                            MainRun.driverAssignments.set(j,driverAssignment);
                        }
                    }
                }

                break;
            case 2:
                for (int i = 0; i < MainRun.driverAssignments.size(); i++) {
                    for (int j = i+1; j < MainRun.driverAssignments.size(); j++) {
                        if(getBusLineSum(MainRun.driverAssignments.get(i)) < getBusLineSum(MainRun.driverAssignments.get(j))){
                            DriverAssignment driverAssignment = MainRun.driverAssignments.get(i);
                            MainRun.driverAssignments.set(i,MainRun.driverAssignments.get(j));
                            MainRun.driverAssignments.set(j,driverAssignment);
                        }
                    }
                }
                for (DriverAssignment a:MainRun.driverAssignments
                ) {
                    System.out.println(a);
                }
                break;
        }
    }
    public static int getBusLineSum(DriverAssignment driverAssignment){
        return driverAssignment.getBusLineDetails().size();
    }

}
