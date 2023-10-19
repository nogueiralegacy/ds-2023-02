package com.github.nogueiralegacy.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class IO {
    public static void acao(Path path) {
        String line;
        String[] campos = new String[2];
        try (
            FileReader fr = new FileReader(path.toString());
            BufferedReader reader = new BufferedReader(fr);
            FileWriter fw = new FileWriter(path.toString().replace(".csv", "_out.csv"));
            BufferedWriter writer = new BufferedWriter(fw);
            ) {
            while ((line = reader.readLine()) != null) {
                campos = line.split(",");
                double numero1 = Double.parseDouble(campos[0]);
                double numero2 = Double.parseDouble(campos[1]);

                writer.write(numero1 + "," + numero2 + "," + Math.round((numero1 + numero2) * 100.0) / 100.0 + "\n");
            }

        } catch(IOException e) {
            System.out.println("Erro ao ler arquivo: " + path.toString() + "\n" + e.getMessage());
        }
    
    }
}
