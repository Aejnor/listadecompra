package com.adolfo.model;

import java.util.ArrayList;
import java.util.Scanner;

public class product {

    private String name;
    private double price;


    // Constructors

    public product() {

    }

    public product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    // Accessors

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Methods

    public int showMenu(ArrayList<String> basketOptions) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> options = new ArrayList<>();
        int option;

        System.out.println("*********************************");
        System.out.println("* 1 - Añadir producto           *");
        options.add(1);
        System.out.println("* 2 - Eliminar producto         *");
        options.add(2);
        System.out.println("* 3 - Consultar lista de compra *");
        options.add(3);
        System.out.println("* 4 - Consultar importe total   *");
        options.add(4);
        System.out.println("* 5 - Tirar carro y RUN FOREST  *");
        options.add(5);
        System.out.println("* 0 - Pagar                     *");
        System.out.println("*********************************");

        do {
            System.out.println("Opcion: ");
            option = input.nextInt();
        } while (option < 0 || option > options.size());


        return option;
    }

    /**
     *
     * @param list
     * @param prices
     */
    public void addProduct(ArrayList<String> list, ArrayList<Double> prices) {
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Introducir producto");
            this.name = input.nextLine().trim().replace("\\s+", " ");
        } while (name.length() == 0);

        do {
            System.out.println("Introducir precio del producto");
            this.price = input.nextInt();
        } while (this.price == 0);
        list.add(name);
        prices.add(price);
        System.out.println();
    }

    /**
     *
     * @param productList
     */
    public void delList(ArrayList<String> productList) {
        Scanner input = new Scanner(System.in);
        int index;
        do {
            System.out.println("Introduce el indice: ");
            index = input.nextInt();
        } while (index <= 0 && index > productList.size());
        productList.remove(index);
    }

    /**
     *
     * @param productList
     * @param productPrice
     */
    public void showProduct(ArrayList<String> productList, ArrayList<Double> productPrice) {

        for (int i = 0; i < productList.size(); i++) {
            System.out.println(((i + 1)) + " - " + productList.get(i) + " " + productPrice.get(i) + " euros");
        }
        System.out.println();

    }

    /**
     *
     * @param totalPrice
     */
    public void totalprice(ArrayList<Double> totalPrice) {
        int suma = 0;
        for (int i = 0; i < totalPrice.size(); i++) {
            suma += totalPrice.get(i);
        }
        System.out.println("El precio del carrito es " + suma + "€");
        System.out.println();
    }

    /**
     *
     * @param payment
     * @param myProduct
     */
    public void paybasket(ArrayList<Double> payment, ArrayList<String> myProduct) {
        showProduct(myProduct, payment);
        totalprice(payment);
        System.out.println("Gracias por realizar su compra.");
        do {
            for (int i = 0; i < myProduct.size(); i++) {
                myProduct.remove(i);
            }
        } while (myProduct.size() > 0);
    }

    /**
     *  Je je, no quieres pagar y corres como si no hubiera un mañana
     * @param productList
     */
    public void dropbasket(ArrayList<String> productList) {
        System.out.println("Has tirado el carro al suelo con:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(((i + 1)) + " - " + productList.get(i));
        }

        System.out.println("Y RUN FOREST, RUNNNNNNNNNNNN!!!!");
        System.out.println();
        do {
            for (int i = 0; i < productList.size(); i++) {
                productList.remove(i);
            }
        } while (productList.size() > 0);
    }
}


