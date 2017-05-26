package mybatis.cheng.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
public class Company {
    public String name;
    public  int price;
    public  int Id;
    public List<Car> listcar;
    public Car car;


    public List<Car> getListcar() {
        return listcar;
    }

    public void setListcar(List<Car> listcar) {
        this.listcar = listcar;
    }





    public Company(){



    }
    public Company(String name,int price){


        this.name=name;this.price=price;
    }
    public Company(String name,int price,int id){
        this.name=name;this.price=price;
        this.Id=id;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Id=" + Id +
                ", listcar=" + listcar +
                ", car=" + car +
                '}';
    }
}
