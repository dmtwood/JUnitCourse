import repositories.PersonsCSVRepository;
import repositories.PersonsRepository;
import services.PersonsService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class StandardDeviationApp {

    public static void main(String[] args) {

        try {
            PersonsService service = new PersonsService( new PersonsCSVRepository() );
            System.out.println(service.findSalaryStandardDeviationList());
        } catch (IOException ioException) {
            ioException.printStackTrace(System.err);
        }


    }
}
