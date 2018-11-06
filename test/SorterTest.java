import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;

public class SorterTest {
    @BeforeEach
    void init() {
        Sorter sorter = new Sorter();
    }

    @Test
    @DisplayName("Creating groups")
    public void testCreateGroups() {
        assertThat({{}, {}, {}}, sorter.createGroups(3));
    }

    @Test
    @DisplayName("Calculate if full iterations are needed")
    @Disabled("until all previous tests are run and working")
    public void testIsFullIterations() {
        sorter.setHasLeftOver(15, 3)
        assertThat(false, sorter.hasLeftOver);
    }

    @Test
    @DisplayName("Calculating how many iterations are required")
    @Disabled("until all previous tests are run and working")
    public void testCalculateIterations() {
        assertThat(6, sorter.calculateIterations(16, 3));
    }

    @Test
    @DisplayName("Inserting numbers into a group")
    @Disabled("until all previous tests are run and working")
    public void testInsertNumber() {
        sorter.createGroups(3);
        sorter.insertNumber(2, 2);
        assertThat({{}, {2}, {}}, sorter.groups;);
    }

    @Test
    @DisplayName("Inserting multiple numbers into groups, no leftover")
    @Disabled("until all previous tests are run and working")
    public void testStart() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);
        test.add(9);
        assertThat({{1, 4, 7}, {2, 5,8}, {3, 6, 9}}, sorter.start(test, 3))
    }
}
