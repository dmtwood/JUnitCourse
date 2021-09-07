package repositories;

import util.PersonsCSVMaker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/*
A Repository is essentially a facade for persistence
that uses Collection style semantics (Add, Update, Remove)
to supply access to data/objects.
It is a way of decoupling the way you store data/objects
from the rest of the application.

The repository is where the data is stored. The service is what manipulates the data.

In a real-world situation comparison, if your money is stored in a vault in a bank, the vault is the repository.
The teller that deposits, withdraws, etc is the service.
 */
public class PersonsCSVRepository implements PersonsRepository {

    @Override
    public List<BigDecimal> getSalariesAsList() throws IOException {
        return Files.lines( Paths.get( "D:\\data\\persons.csv" ) )
                .map( textline -> textline.split(",")[3] )
                .map( BigDecimal::new )
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal[] getSalariesAsArray() throws IOException {
        return Files.lines( Paths.get("D:\\data\\persons.csv" ) )
                .map( textline -> new BigDecimal(textline.split(",")[3] ) )
                .toArray( BigDecimal[]::new );
    }


}
