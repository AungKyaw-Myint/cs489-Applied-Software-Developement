import model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {

        Product p1 =new Product(999999999L, "Carrot", LocalDate.of(2024, 3, 31), 89, 2.99);
        Product p2 =new Product(888888888L, "Banana", LocalDate.of(2020, 1, 8), 65, 0.98);
        Product p3 =new Product(777777777L, "Orange", LocalDate.of(2011, 4, 12), 42, 1.23);

        Product[] products={p1,p2,p3};


        printProducts(products);
    }

    public static void printProducts(Product[] products){
        Arrays.sort(products, Comparator.comparingDouble(Product::getUnitPrice).reversed());

        printJsonFormat(products);
        System.out.println("-------------");
        printXmlFormat(products);
        System.out.println("-------------");
        printCsvlFormat(products);
    }


    public static void printJsonFormat(Product[] products){
        System.out.println("Printed in JSON format");
        System.out.println("[");
        for(Product p:products){
            System.out.println("\t"+p.getJson());
        }
        System.out.println("]");
    }

    public static void printXmlFormat(Product[] products){
        System.out.println("Printed in XML format");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<products>");
        for(Product p:products){
            System.out.println("\t"+p.getXml());
        }
        System.out.println("</products>");
    }

    public static void printCsvlFormat(Product[] products){
        System.out.println("Printed in CSV format");
        for(Product p:products){
            System.out.println(p.getCsv());
        }
    }
}