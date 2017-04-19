package com.adolfo.controller;

import com.adolfo.model.product;

import java.util.ArrayList;

/*
Desarrollar una aplicación que nos permita confeccionar una lista de artículos que compramos
en un supermercado a través de la cual podamos calcular el importe total de dicha lista.

Considerando que un artículo estará definido por un nombre y un precio, nuestro programa se
ejecutará mostrando un menú en el que podemos añadir un artículo, eliminarlo si deseamos no
tenerlo en la lista, mostrar la lista de artículos y consultar el importe total de la lista.

Después de realizar cada acción el programa volverá a mostrar el menú y solo interrumpirá su ejecución si se selecciona la opcion 0.

*******************************
* 1 - Añadir producto         *
* 2 - Eliminar producto       *
* 3 - Mostrar lista artículos *
* 4 - Consultar importe total *
* 0 - Pagar                   *
*******************************
Opción:
El funcionamiento de las opciones es el siguiente:

1: el programa pedirá los datos necesarios de un artículo y lo añadirá a la lista.
2: el programa mostrará la lista de artículos y pedirá el índice (posición en la lista)
    del artículo a eliminar. Tras esto procederá a eliminar el artículo de la lista.
3: mostrará la lista de artículos con su nombre y precio.
4: imprimirá el importe total de la lista de artículos.
5: imprime la lista de artículos con nombres y precios, el importe total y termina el programa.
Debes diseñar una aplicación en Java que resuelva el problema propuesto apoyándote en el uso de ArrayList.
Como restricción intenta que en la clase Main (clase de inicio de la aplicación) haya el menor número de líneas de código.
 */
public class Main {

    public static void main(String[] args) {

    product product = new product();

    ArrayList<String> productList = new ArrayList<String>();
    ArrayList<Double> productPrice = new ArrayList<Double>();

    int option;

    while (( option = product.showMenu(productList)) != 0){
        switch (option){
            case 1:
                product.addProduct(productList, productPrice);
                break;
            case 2:
                product.delList(productList);
                break;
            case 3:
                if (productList.size()>0){
                    product.showProduct(productList, productPrice);
                }
                break;
            case 4:
                product.totalprice(productPrice);
                break;
            case 5:
                product.dropbasket(productList);
            case 0:
                product.paybasket(productPrice, productList);
                break;
            default:
        }
    }

    }
}
