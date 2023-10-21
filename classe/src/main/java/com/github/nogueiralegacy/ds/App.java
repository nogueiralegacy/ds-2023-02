package com.github.nogueiralegacy.ds;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.github.nogueiralegacy.ds.domain.Buscador;

public class App 
{
    public static void main( String[] args ) {
        if (args.length < 2) {
            System.out.println("Necessario nome da classe e diretorio");
            System.exit(0);
        }

        String className = args[0];
        String dir = args[1];

        List<String> classesJava = null;
        if (Files.exists(Paths.get(dir))) {
            if (args.length > 2 && usarStreamParalelo(args[2])) {
                classesJava = Buscador.buscarArquivoParalelo(dir, className);
            } else {
                classesJava = Buscador.buscarArquivo(dir, className);
            }
        }
        if (classesJava == null || classesJava.isEmpty()) {
            System.out.println("Nao foi encontrado nenhum arquivo");
            System.exit(0);
        }
        else {
            for (String classe : classesJava) {
                System.out.println(classe);
            }
        }
        System.out.println("Quantidade de arquivos consultados: " + Buscador.getQntArquivosConsultados());

    }

    private static boolean usarStreamParalelo(String arg) {
        return arg.equals("-p");
    }
}
