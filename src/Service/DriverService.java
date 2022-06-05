package Service;

import Entity.Driver;
import File.FileUtil;
import Main.MainRun;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService implements GeneralMethod{
    public static final String file = "src/Driver.dat";
    public static FileUtil fileUtil = new FileUtil();
    @Override
    public void createNew() {
        System.out.print("nhập số lượng lái xe");
        int quantity = 0;
        do{
            try {
                quantity = new Scanner(System.in).nextInt();
                if(quantity >=0){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("phải là số");
            }
        }while (true);
        for (int i = 0; i < quantity; i++) {
            Driver driver = new Driver();
            driver.inputDriver();
            MainRun.drivers.add(driver);
        }
        fileUtil.writeData(Collections.singletonList(MainRun.drivers),file);
    }




    @Override
    public void show() {
        for (Driver driver : MainRun.drivers){
            System.out.println(driver);
        }
    }

    @Override
    public boolean check() {
        if (MainRun.drivers.isEmpty()){
            return true;
        }
        return false;
    }
}
