package Service;

import Entity.BusLine;
import File.FileUtil;
import Main.MainRun;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusLineService implements GeneralMethod{
    public static final String file = "src/BusLine.dat";
    public static FileUtil fileUtil = new FileUtil();
    @Override
    public void createNew() {
        int quantity = 0;
        do{
            try{
                System.out.println("nhập số lượng tuyến đường");
                quantity = new Scanner(System.in).nextInt();
                if(quantity > 0)break;
            }catch (InputMismatchException e){
                System.out.println("số tuyền đường phải là số dương");
            }
        }while (true);
        for (int i = 0; i < quantity; i++) {
            BusLine busLine = new BusLine();
            busLine.inputBusLine();
            MainRun.busLines.add(busLine);
        }
        fileUtil.writeData(Collections.singletonList(MainRun.busLines),file);
    }

    @Override
    public void show() {
        for (BusLine busLine :MainRun.busLines) {
            System.out.println(busLine);
        }
    }

    @Override
    public boolean check() {
        if (MainRun.busLines.isEmpty()) return true;
        return false;
    }
}
