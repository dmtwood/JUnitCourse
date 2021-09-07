package util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PersonsCSVMaker {

    private static final String[] FIRST_NAMES = {
            "Piet", "Dick", "Ben", "Dies", "Conny", "Willy", "Wil",
            "Charel", "Izzy", "Klaar", "Benny", "Danny"
    };

    private static final String[] LAST_NAMES = {
            "Van den Broeck" , "De Decker", "de Lange", "van de Pol", "Coome",
            "De Wilde", "Grootaers", "Van Agteren", "van Voren", "Deman",
            "van Reeth", "Schotanus", "De Cock", "Uijttenbroek", "In 't Hol"
    };

    private static final Path filePath = Paths.get(
            "D:\\data\\persons.csv"
    );

    private static final Path dirPath = filePath.getParent();


    public static void main(String[] args) throws IOException {

        if (!Files.isDirectory( dirPath ) ) {
            Files.createDirectories( dirPath );
        }

//        if ( ! Files.exists( filePath ) ) {
//            Files.createFile( filePath );
//        }

        Random random = new Random();
        try (
                BufferedWriter bufWriter = Files.newBufferedWriter( filePath )
        ) {
            for (int i = 0; i < 100_000; i++ ) {

                bufWriter.write( String.valueOf(i) );
                bufWriter.write(',');

                bufWriter.write( FIRST_NAMES[ random.nextInt(FIRST_NAMES.length) ] );
                bufWriter.write(',');

                bufWriter.write( LAST_NAMES[ random.nextInt(LAST_NAMES.length) ] );
                bufWriter.write(',');

                // generate a random salary between 2_000.00 & 6_999.99
                bufWriter.write( String.valueOf(2000 + random.nextInt(5000)) );
                bufWriter.write('.');
                bufWriter.write(String.valueOf(random.nextInt(100)));

                bufWriter.newLine();
                System.out.printf("%d%n", i);
            }
        }
        System.out.println("File is created.");
    }
}




























