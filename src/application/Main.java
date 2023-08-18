package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            switch (ch){
                case 'i':
                    System.out.print("Customs fee: ");
                    Double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name,price,customsFee));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate =  sdf.parse(sc.next());
                    list.add(new UsedProduct(name,price,manufactureDate));
                    break;

                default: list.add(new Product(name,price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product prod : list){
            System.out.println(prod.priceTag());
        }


        sc.close();
    }
}