package com.github.nogueiralegacy.ds.domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class Buscador {
    private static int qntArquivosConsultados = 0;
    public static boolean isArquivoClass(String nome) {
        return nome.endsWith(".class");
    }

    public static boolean isArquivoJar(String nome) {
        return nome.endsWith(".jar");
    }

    public static boolean isArquivoWar(String nome) {
        return nome.endsWith(".war");
    }

    public static List<String> buscandoArquivosJarFile(String jarfilePath, String className) {
        List<String> listaArquivos = new ArrayList<>();

        try (JarFile jarFile = new JarFile(jarfilePath)) {
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();

                //adiciona uma consulta
                qntArquivosConsultados++;

                if (isArquivoClass(jarEntry.getName()) && isClasseDesejada(jarEntry.getName(), className)) {
                    listaArquivos.add(Paths.get(jarfilePath, jarEntry.getName()).toString());
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return listaArquivos;
    }

    private static boolean isClasseDesejada(String verificar, String className) {
        return verificar.replace(".class", "").equals(className);
    }

    public static List<String> buscarArquivo(String dirPath, String className) {
        List<String> listaArquivos = new ArrayList<>();
    
        File dir= new File(dirPath);
        String[] conteudoDiretorio = dir.list();
        Stream<String> stream = Arrays.stream(conteudoDiretorio);



        // selecionar todos as arquivos .class
        stream
        .forEach(conteudo -> {
            // Adiciona uma consulta
            qntArquivosConsultados++;

            String caminhoAbsoluto = Paths.get(dirPath, conteudo).toString();

            if (isArquivoClass(caminhoAbsoluto) && isClasseDesejada(conteudo, className)) {
                listaArquivos.add(caminhoAbsoluto);
            }
            if (isArquivoJar(conteudo)) {
                listaArquivos.addAll(buscandoArquivosJarFile(caminhoAbsoluto, className));
            }
            if (Files.isDirectory(Paths.get(caminhoAbsoluto))) {
                listaArquivos.addAll(buscarArquivo(caminhoAbsoluto, className));
            }
        });

        return listaArquivos;
    }

    public static List<String> buscarArquivoParalelo(String dirPath, String className) {
        List<String> listaArquivos = new ArrayList<>();

        File dir = new File(dirPath);

        String[] conteudoDiretorio = dir.list();


        Stream<String> stream = Arrays.stream(conteudoDiretorio);

        // selecionar todos as arquivos .class
        stream
        .parallel()
        .forEach(conteudo -> {
            String caminhoAbsoluto = Paths.get(dirPath, conteudo).toString();

            if (isArquivoClass(caminhoAbsoluto) && isClasseDesejada(conteudo, className)){
                listaArquivos.add(caminhoAbsoluto);
            }
            if (isArquivoJar(conteudo)) {
                listaArquivos.addAll(buscandoArquivosJarFile(caminhoAbsoluto, className));
            }
            if (Files.isDirectory(Paths.get(caminhoAbsoluto))) {
                listaArquivos.addAll(buscarArquivoParalelo(caminhoAbsoluto, className));
            }
        });

        return listaArquivos;
    }

    public static int getQntArquivosConsultados() {
        return qntArquivosConsultados;
    }
}
