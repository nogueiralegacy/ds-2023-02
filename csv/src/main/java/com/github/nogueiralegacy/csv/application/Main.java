package com.github.nogueiralegacy.csv.application;

import java.util.Scanner;

import com.github.nogueiralegacy.csv.IO;
import com.github.nogueiralegacy.csv.utils.Utils;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Nome do arquivo na pasta resources: ");
            String fileName = sc.nextLine();
            IO.acao(new Utils().getPath(fileName));
        }
    }
}
