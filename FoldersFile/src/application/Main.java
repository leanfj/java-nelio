package application;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Manipulação de arquivos");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Entre com o nome caminho: ");
        String strPath = scanner.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("Folders: ");

        for(File folder : folders) {
            System.out.println(folder);
        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        File[] files = path.listFiles(File::isFile);

        System.out.println("Files: ");

        for(File file : files) {
            System.out.println(file);
        }

        System.out.println("New Folder name");
        String newFolder = scanner.nextLine();

        boolean success = new File(strPath + "/" + newFolder).mkdir();

        System.out.println("Diretorio criado com sucesso " + success);

        scanner.close();
    }
}