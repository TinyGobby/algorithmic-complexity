import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SorterTest {
    Sorter sorter;

    @BeforeEach
    void init() {
        sorter = new Sorter();
    }

    @Test
    @DisplayName("Creating groups")
    public void testCreateGroups() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>());
        expected.add(new ArrayList<Integer>());
        assertEquals(expected, sorter.createGroups(3));
    }

//    @Test
//    @DisplayName("Calculate if full iterations are needed")
//    @Disabled("as no longer needed")
//    public void testIsFullIterations() {
//        sorter.setHasLeftOver(15, 3);
//        assertThat(false, sorter.hasLeftOver);
//    }

    @Test
    @DisplayName("Calculating how many iterations are required")
    public void testCalculateIterations() {
        Sorter sorter = new Sorter();
        assertEquals(6, sorter.calculateIterations(16, 3));
    }

    @Test
    @DisplayName("Inserting numbers into a group")
    public void testInsertNumber() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        expected.add(new ArrayList<Integer>());
        two.add(2);
        expected.add(two);
        expected.add(new ArrayList<Integer>());

        sorter.createGroups(3);
        sorter.insertNumber(1, 2);
        assertEquals(expected, sorter.groups);
    }

    @Test
    @DisplayName("Inserting multiple numbers into groups, no leftover")
    public void testRunWithoutLeftover() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(4);
        expected.add(one);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(5);
        expected.add(two);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(3);
        three.add(6);
        expected.add(three);

        assertEquals(expected, sorter.run(test, 3));
    }

    @Test
    @DisplayName("Inserting multiple numbers into groups with leftover")
    public void testRunWithLeftover() {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);

        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(4);
        one.add(7);
        expected.add(one);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(2);
        two.add(5);
        two.add(8);
        expected.add(two);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(3);
        three.add(6);
        expected.add(three);

        assertEquals(expected, sorter.run(test, 3));
    }
}
