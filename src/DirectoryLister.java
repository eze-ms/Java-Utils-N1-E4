import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;
import auxiliar.Utils;

public class DirectoryLister {

    //! Punto de inicio del programa.
    static void init(String[] args) {
        if (args.length < 1) {
            System.out.println("Input the path to a TXT file:");
            String filePath = new Scanner(System.in).nextLine(); // Solicita la ruta manualmente.
            readTxtFile(filePath);
        } else {
            readTxtFile(Utils.argsToString(args)); // Lee el archivo proporcionado como argumento.
        }
    }


    //! Lista recursivamente el contenido de un árbol de directorios y guarda el resultado en un archivo TXT.
    public static void listDirectoryTreeAndSave(String directoryPath) {
        Path path = Utils.validatePath(directoryPath);

        if (path == null) return; // Si el Path no es válido, detiene la ejecución.

        Path outputFile = Path.of("directory_list.txt"); // Archivo de salida.
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("Directory listing for: " + path + "\n\n");
            listDirectoryTreeRecursive(path, 0, writer);
            System.out.println("Directory listing saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    //! Metodo recursivo para listar un árbol de directorios con detalles y guardar en un archivo.
    public static void listDirectoryTreeRecursive(Path path, int level, BufferedWriter writer) {
        try (Stream<Path> pathStream = Files.list(path).sorted()) {
            pathStream.forEach(file -> {
                try {
                    String type = Files.isDirectory(file) ? "D" : "F";
                    String date = Utils.formatLastModified(file.toFile().lastModified());

                    // Formato de la información
                    String line = String.format("%s[%s] %s (Last Modified: %s)%n", "  ".repeat(level), type, file.getFileName(), date);

                    // Escribe la información en el archivo
                    writer.write(line);

                    // Si es un directorio, llamar recursivamente
                    if (Files.isDirectory(file)) {
                        listDirectoryTreeRecursive(file, level + 1, writer);
                    }
                } catch (IOException e) {
                    System.out.println("Error processing file: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error reading the directory: " + e.getMessage());
        }
    }

    //! Lee un archivo TXT y muestra su contenido en la consola.
    public static void readTxtFile(String filePath) {
        Path path = Utils.validatePath(filePath);

        if (path == null || !Files.isRegularFile(path)) { // Asegúrate de que sea un archivo regular.
            System.out.println("The provided path is not a valid file.");
            return;
        }

        try {
            Files.lines(path).forEach(System.out::println); // Lee y muestra cada línea del archivo.
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

}
