package Service;

import Entity.BusLine;
import Entity.BusLineDetail;
import Entity.Driver;
import Entity.DriverAssignment;
import File.FileUtil;
import Main.MainRun;

import java.util.*;

public class AssigmentList {
    public static final String file = "src/Assigment.dat";
    public static FileUtil fileUtil = new FileUtil();
    public static Driver inputDriver() {
        int id =0;
        Driver driver = null;
        do {
            try {
                System.out.print("nhập mã lái xe");
                id = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.println("mã tài xế phải là số dương");
            }
            for (int i = 0; i < MainRun.drivers.size(); i++) {
                if(MainRun.drivers.get(i).getId() == id){
                    driver = MainRun.drivers.get(i);
                }
            }
            if(driver != null) break;
        }while (true);
        return driver;
    }

    public  static BusLine inputBusLine(){
        int id = 0;
        BusLine busLine = null;
        do{
            try {
                id = new Scanner(System.in).nextInt();
            }catch (InputMismatchException e){
                System.out.println("mã tuyến đường phải là số dương");
            }
            for (int i = 0; i < MainRun.busLines.size(); i++) {
                if(MainRun.busLines.get(i).getId() == id){
                    busLine = MainRun.busLines.get(i);
                }
            }
            if(busLine!=null) break;
        }while (true);
        return busLine;
    }
    public void assigmentList() {
        BusLineService busLineService = new BusLineService();
        DriverService driverService = new DriverService();
        if(busLineService.check() && driverService.check()){
            System.out.println("cần nhập thông tin lái xe và tuyến đường trước khi phân công");
            return;
        }
        int quantity = 0;
        do{
            try {
                System.out.print("nhập số lượng lái xe muốn phân công ");
                quantity = new Scanner(System.in).nextInt();
                if(quantity > 0 && quantity <= MainRun.drivers.size()) break;
                System.out.println("số tài xế phải nhỏ hơn tổng số tài xế");
            }catch (IncompatibleClassChangeError e){
                System.out.println("cần phải nhập số nguyên dương");
            }
        }while (true);
        for (int i = 0; i < quantity; i++) {
            int count =0;
            int temp =0;
            Driver driver = inputDriver();
            System.out.print("Nhập sô tuyến đường muốn phân công cho lái xe");
            int busLineNumber =0;
            do {
                try {
                    busLineNumber = new Scanner(System.in).nextInt();
                    if(busLineNumber > 0 && busLineNumber <= MainRun.busLines.size()){
                        break;
                    }
                    System.out.println("số tuyến đường phải lớn hơn 0 và nhỏ hơn tổng số tuyến đường");
                }catch (InputMismatchException e){
                    System.out.println("số tuyến đường phải lớn hơn 0 và nhỏ hơn tổng số tuyến đường");
                }
            }while (true);
            List<BusLineDetail> busLineDetails = new ArrayList<>();
            for (int j = 0; j < busLineNumber; j++) {
                System.out.print("nhập mã tuyến đường thứ "+(j+1)+ " ");
                BusLine busLine = inputBusLine();
                if(check(driver.getId() , busLine.getId() , busLineDetails)){
                    System.out.println("đã tồn tại");
                    continue;
                }
                int turnNumber =0;
                do{
                    try {
                        System.out.print("nhập số lượt ");
                        turnNumber = new Scanner(System.in).nextInt();
                        if(turnNumber >0 && turnNumber <=15){
                            temp += turnNumber;
                            break;
                        }
                        System.out.println("Không quá 15 lượt");
                    }catch (InputMismatchException e){
                        System.out.println("nhập lại");
                    }

                }while (true);

                busLineDetails.add(new BusLineDetail(busLine,temp));
            }
            DriverAssignment driverAssignment = new DriverAssignment(driver , busLineDetails);
            MainRun.driverAssignments.add(driverAssignment);
        }
        for (DriverAssignment a:MainRun.driverAssignments
             ) {
            System.out.println(a);
        }
        fileUtil.writeData(Collections.singletonList(MainRun.driverAssignments),file);
    }
    public  static boolean check (int idDriver , int idBusLine , List<BusLineDetail> busLineDetails){
        for (int i = 0; i < MainRun.driverAssignments.size(); i++) {
            if (MainRun.driverAssignments.get(i).getDriver().getId() == idDriver){
                List<BusLineDetail> list = MainRun.driverAssignments.get(i).getBusLineDetails();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).getBusLine().getId() == idBusLine){
                        return true;
                    }
                }
            }
        }
        for (int i = 0; i < busLineDetails.size(); i++) {
            if(busLineDetails.get(i).getBusLine().getId() == idBusLine) return true;
        }
        return false;
    }
}
