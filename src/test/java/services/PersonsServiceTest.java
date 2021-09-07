package services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.PersonsRepositorySTUB;

import java.io.IOException;

class PersonsServiceTest {

    private PersonsService personsService;

    @BeforeEach
    void beforeEach() {
        personsService = new PersonsService( new PersonsRepositorySTUB() );
    }


    @Test
    void findSalaryDeviation_isPositive() throws IOException {
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviation()
                ).isPositive();
    }

    @Test
    void findSalaryDeviationList_isPositive() throws IOException {
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviationList()
                ).isPositive();
    }

    @Test
    void findSalaryDeviationList_forStubIs2() throws IOException {
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviationList()
                ).isEqualByComparingTo("2");
    }
}
