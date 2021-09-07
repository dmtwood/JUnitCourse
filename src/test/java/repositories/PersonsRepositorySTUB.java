package repositories;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 De stub implementeert dezelfde interface als de echte dependency.

 De method geeft een verzameling getallen terug.
 Je gebruikt de getallen uit het artikel op
https://en.wikipedia.org/wiki/Standard_deviation, in de paragraaf met als titel
“Population standard deviation of grades of eight students”.
De standaardafwijking van deze getallen 2 is.
 */
public class PersonsRepositorySTUB implements PersonsRepository {

    @Override
    public List<BigDecimal> getSalariesAsList() {
        return Arrays.asList(
                BigDecimal.valueOf(2), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(4), BigDecimal.valueOf(5),
                BigDecimal.valueOf(5), BigDecimal.valueOf(7), BigDecimal.valueOf(9)
        );
    }

    @Override
    public BigDecimal[] getSalariesAsArray()  {
        return new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(4), BigDecimal.valueOf(5),
                BigDecimal.valueOf(5), BigDecimal.valueOf(7), BigDecimal.valueOf(9)
        };
    }
}
