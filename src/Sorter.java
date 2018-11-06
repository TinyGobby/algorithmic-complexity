import java.util.ArrayList;

public class Sorter {
    public static ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
    public static boolean hasLeftOver;
//    public static void main (String[] args) { }

    public static ArrayList createGroups(int number) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            groups.add(temp);
        }
        return groups;
    }

    public static void setHasLeftOver(int cohortSize, int number) {
        hasLeftOver = cohortSize % number == 0;
    }

    public static int calculateIterations(int cohortSize, int number) {
        return cohortSize / number + 1;
    }

    public static void insertNumber(int group, int number) {
        groups.get(group).add(number);
    }

    public static ArrayList start(ArrayList cohort, int number) {

    }

//groups(cohort, number)
//create number groups
//iterations = divide cohort length by number and add 1
//iterations times: (or do until cohort is empty)
//  number times:
//    Take last name from cohort and add to each group in order

//# OR

//groups(cohort, number)
//g_size = divide cohort length by number
//number times:
//  group (i) = take g_size number of names from cohort
//For length of remaining cohort:
//  Take last name and add to group (i)
}
