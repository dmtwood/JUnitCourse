package repositories;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface PersonsRepository {

    List<BigDecimal> getSalariesAsList() throws IOException;

    BigDecimal[] getSalariesAsArray() throws IOException;
}
