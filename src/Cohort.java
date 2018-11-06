//import java.util.ArrayList;
//
//public class Cohort {
//    public static void main(String[] args) {
//
//        cohorting();
//        cohortDetails();
//        theDivision();
//        cohortCleanup();
//        cohortGrouping();
//        finalCohortGrouping();
//    }
//
//    // Creation of the cohort
//    public static ArrayList cohorting() {
//        ArrayList<String> aug18 = new ArrayList<>();
//        aug18.add("Patrick");
//        aug18.add("Sebastian");
//        aug18.add("Nazziya");
//        aug18.add("Amy");
//        aug18.add("Chloe");
//        aug18.add("Din");
//        aug18.add("Damion");
//        aug18.add("Ruaridhi");
//        aug18.add("Freya");
//        aug18.add("Victor");
//        aug18.add("Shwetza");
//        aug18.add("Nathan");
//        aug18.add("Alex");
//        aug18.add("Vu");
//        aug18.add("Robbie");
//        aug18.add("Ibrahim");
//        return aug18;
//    }
//    // The overall size of the cohort
//    public static int cohortDetails() {
//        int cohortSize = cohorting().size();
//        return cohortSize;
//    }
//
//    // The size number of groups you want
//    public static int theDivision() {
//        int numberofGroups = 3;
//        return numberofGroups;
//    }
//
//    // How many members left over when divided into equal groups
//    public static int cohortCleanup() {
//        int groupDivision = cohortDetails() % theDivision();
//        return groupDivision;
//    }
//
//    //Creation of equal groups
//    public static ArrayList cohortGrouping() {
//        int cleanGroups = ((cohortDetails() - cohortCleanup()) / theDivision());
//        ArrayList<Integer> jesustakeTheWheel = new ArrayList<>();
//
//        while (jesustakeTheWheel.size() <= (theDivision())) {
//            jesustakeTheWheel.add(cleanGroups);
//        }
//        return jesustakeTheWheel;
//    }
//
//    //Adding the the odd ones out
//    public static ArrayList finalCohortGrouping() {
//        int remainder = cohortCleanup();
//        while (remainder > 0 ) {
//            for
//        }
//    }
//}
//
