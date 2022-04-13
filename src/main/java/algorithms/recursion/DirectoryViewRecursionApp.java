package algorithms.recursion;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.Utils.println;

public class DirectoryViewRecursionApp {

    public static void main(String[] args) {
        var app = new DirectoryViewRecursionApp();
        Path rootPath = Paths.get(System.getProperty("user.dir"), "src");

        app.pathTreePrint(rootPath);
    }

    @SneakyThrows
    private void pathTreePrint(Path rootPath) {
        Files.list(rootPath)
                .forEach(path -> {
                    println(path);
                    if (Files.isDirectory(path)) {
                        pathTreePrint(path);
                    }
                });
    }

}
