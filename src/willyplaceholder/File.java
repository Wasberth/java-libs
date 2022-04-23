/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package willyplaceholder;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Willy
 */
public class File {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner sc = new Scanner(System.in);
        final String dir; //"C:\\Users\\Willy\\Desktop\\post.txt";

        System.out.println("Ingrese la ruta del archivo");
        dir = sc.nextLine();

        final java.io.File file = new java.io.File(dir);

        if (!file.exists()) {
            System.out.println("El archivo que ingresó no existe");
            return;
        }

        if (!file.canRead()) {
            System.out.println("El archivo que ingresó no puede ser leído");
            return;
        }

        final Scanner reader = new Scanner(file);

        if (!reader.hasNextLine()) {
            System.out.println("El archivo está vacío");
            return;
        }

        final String content = reader.nextLine();
        
        System.out.println("Evaluando: " + content);
    }
}
