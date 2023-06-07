package tn.usousse.eniso.get1.stage1;
import tn.usousse.eniso.get1.stage1.presentation.model.Table;
import tn.usousse.eniso.get1.stage1.service.AppService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       AppService service = new AppService(new Table(3));
        String name = "";
        String operation="start";
        System.out.println("Hey! You can get started");
        while (!(operation.equals("exit"))){
            Scanner demand=new Scanner(System.in);
            operation=demand.nextLine();
            operation=operation.trim();
            String[] listOfItems=operation.split(" +");
            if (listOfItems.length==2){
                operation=listOfItems[0];
                name=listOfItems[1];}
            else {
                operation=listOfItems[0];
            }
            switch(operation){
                case "add": {service.add(name);break;}

                case "remove":{
                    if (service.remove(name)==true){
                        System.out.println(name+" removed");
                    }
                    else {
                        System.out.println(name+" not found!");
                    }
                    service.remove(name);

                    break;}
                case "find":{System.out.println(service.find(name));break;}
                case"list":{service.list(); break;}
                case"exit":{break;}
                default:
                    System.out.println("no valid operation");
            }}
    }
}