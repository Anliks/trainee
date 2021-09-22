package com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {

        int washer = 1;
        int[] clients = {3,7,8,4};

                if(washer <= 0) {   //Проверка на случай если количество машин 0,1
            System.out.println("We do not Work");
        } else if (washer == 1) {
            System.out.println(Arrays.stream(clients).sum());
        } else if (washer > clients.length-1) {    // если стиролок больше чем клиентов
                    OptionalInt max = Arrays.stream(clients).max();
                    System.out.println(max.getAsInt());
                } else {
                    System.out.println("lead time = " + countingTheTime(clients, washer) + " minutes!");
                }
    }

    public static int countingTheTime(int[] clients, int washer) { // вычисление в случае если машин больше 1
        int last = clients.length-1;
        int first = washer;
        //int current = washer;
        ArrayList<Integer> list = new ArrayList<>();
        // Загружаем машинки
        for(int i = 0; i <= washer-1; i++ ) {
            list.add(clients[i]);
            //first = current;
        }
        while (last >= first) {
            Collections.sort(list);
            list.set(0, list.get(0) + clients[first]);
            first++;
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
