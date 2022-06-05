package Main;

import Entity.BusLine;
import Entity.Driver;
import Entity.DriverAssignment;
import Service.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static List<Driver> drivers = new ArrayList<>();
    public static List<BusLine> busLines = new ArrayList<>();
    public static List<DriverAssignment> driverAssignments = new ArrayList<>();

    public static void main(String[] args) {
        DriverService driverService = new DriverService();
        BusLineService busLineService = new BusLineService();
        AssigmentList assigmentList = new AssigmentList();
        Sort sort = new Sort();
        StatisticalDistance statisticalDistance = new StatisticalDistance();
        int option = 0;
        while (true) {
            System.out.println("mời bạn nhập lựa chọn");
            System.out.println("1: nhập lái xe");
            System.out.println("2: in lái xe");
            System.out.println("3: Nhập tuyến");
            System.out.println("4: in ra tuyến");
            System.out.println("5: phân côngn");
            System.out.println("6: sắp xếp");
            System.out.println("7: thống kê");
            do {
                try {
                    option = new Scanner(System.in).nextInt();
                    if (option > 0 && option <= 7) {
                        break;
                    }
                    System.out.println("không có lựa chọn");
                } catch (InputMismatchException e) {
                    System.out.println("không có lựa chọn");
                }
            } while (true);
            switch (option) {
                case 1:
                    driverService.createNew();
                    break;
                case 2:
                    driverService.show();
                    break;
                case 3:
                    busLineService.createNew();
                    break;
                case 4:
                    busLineService.show();
                    System.out.println(MainRun.busLines.size());
                    break;
                case 5:
                    assigmentList.assigmentList();
                    break;
                case 6:
                    sort.sort();
                    break;
                case 7:
                    statisticalDistance.statisticalDistance();
                    break;
            }
        }
    }

}
