package Entity;

import java.io.Serializable;
import java.util.Scanner;

public class People implements Serializable {
    private String name;
    private String address;
    private String phone;

    public People() {
    }

    public People(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void inputPeople() {
        System.out.print("nhập họ tên lái xe ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("nhập địa chỉ lái xe ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("nhập số điện thoại lái xe ");
        this.phone = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
