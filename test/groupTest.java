import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class groupTest {
    @Test
    void test() {
        Cohort cohort = new Cohort();
        assertThat(16, equalTo(cohort.cohortDetails()));
        assertThat(1, equalTo(cohort.cohortGrouping()));
        System.out.print(cohort.cohortGrouping());
    }
}

