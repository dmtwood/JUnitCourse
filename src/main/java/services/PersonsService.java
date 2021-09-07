package services;

import repositories.PersonsRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/*
A service supplies coordination or other "services" that are required to operate your application.
They are very different in that Services don't typically know how to access data from persistence,
and repositories typically only access data/objects for any services you may have

The repository is where the data is stored. The service is what manipulates the data.
In a real-world situation comparison, if your money is stored in a vault in a bank, the vault is the repository.
The teller that deposits, withdraws, etc. is the service.
 */
public class PersonsService {

    private final PersonsRepository personsRepository;

    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public BigDecimal findSalaryStandardDeviation() throws IOException {

        BigDecimal [] wages = personsRepository.getSalariesAsArray();
        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal wage : wages) {
            total = total.add(wage);
        }

        BigDecimal avg = total.divide(
                BigDecimal.valueOf(wages.length),
                2,
                RoundingMode.HALF_UP );

        total = BigDecimal.ZERO;

        for (BigDecimal wage : wages ) {
            BigDecimal subtraction = wage.subtract( avg );
            BigDecimal toSecondPower = subtraction.pow(2);
            total = total.add(toSecondPower);
        }

        BigDecimal deviance = total.divide(
                BigDecimal.valueOf(wages.length),
                2,
                RoundingMode.HALF_UP );

        return BigDecimal.valueOf( Math.sqrt( deviance.doubleValue() ) );
    }


    public BigDecimal findSalaryStandardDeviationList() throws IOException {

        List<BigDecimal> wages = personsRepository.getSalariesAsList();
        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal wage : wages) total = total.add(wage);

        BigDecimal avg = total.divide(
                BigDecimal.valueOf(wages.size()),
                2,
                RoundingMode.HALF_UP );

        total = BigDecimal.ZERO;

        for (BigDecimal wage : wages ) {
            BigDecimal subtraction = wage.subtract( avg );
            BigDecimal toSecondPower = subtraction.pow(2);
            total = total.add(toSecondPower);
        }

        BigDecimal deviance = total.divide(
                BigDecimal.valueOf(wages.size()),
                2,
                RoundingMode.HALF_UP );

        return BigDecimal.valueOf( Math.sqrt( deviance.doubleValue() ) );
    }

}
