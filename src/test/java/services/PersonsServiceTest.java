package services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.PersonsRepository;
import repositories.PersonsRepositorySTUB;

import java.io.IOException;
import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonsServiceTest {

    private PersonsService personsService;

    @Mock
    private PersonsRepository personsMockRepository;

    @BeforeEach
    void beforeEach() {
        personsService = new PersonsService(
//                new PersonsRepositorySTUB()
                personsMockRepository
        );
    }


    @Test
    void findSalaryDeviation_isPositive() throws IOException {
        when(personsMockRepository.getSalariesAsArray()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9), });
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviation()
                ).isPositive();
        verify(personsMockRepository).getSalariesAsArray();
    }

    @Test
    void findSalaryDeviationList_isPositive() throws IOException {
        when(personsMockRepository.getSalariesAsArray()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9), });
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviation()
                ).isPositive();
        verify(personsMockRepository).getSalariesAsArray();
    }

    @Test
    void findSalaryDeviationList_forStubIs2() throws IOException {
        when(personsMockRepository.getSalariesAsArray()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9), });
        Assertions
                .assertThat(
                        personsService.findSalaryStandardDeviation()
                ).isEqualByComparingTo("2");
        verify(personsMockRepository).getSalariesAsArray();
    }
}
