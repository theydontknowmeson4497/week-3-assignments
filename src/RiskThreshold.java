import java.util.Arrays;

public class RiskThreshold {

    // Linear Search: unsorted array
    public static int linearSearch(int[] risks, int target) {
        int comparisons = 0;
        for (int i = 0; i < risks.length; i++) {
            comparisons++;
            if (risks[i] == target) {
                System.out.println("Linear: threshold=" + target + " found at index " + i + " (" + comparisons + " comps)");
                return i;
            }
        }
        System.out.println("Linear: threshold=" + target + " not found (" + comparisons + " comps)");
        return -1;
    }

    // Binary Search variants: floor and ceiling
    public static void binaryFloorCeiling(int[] risks, int target) {
        int low = 0, high = risks.length - 1;
        int comparisons = 0;
        int floor = Integer.MIN_VALUE, ceiling = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            if (risks[mid] == target) {
                floor = risks[mid];
                ceiling = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid]; // candidate floor
                low = mid + 1;
            } else {
                ceiling = risks[mid]; // candidate ceiling
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(" + target + "): " + (floor == Integer.MIN_VALUE ? "None" : floor)
                + ", ceiling: " + (ceiling == Integer.MAX_VALUE ? "None" : ceiling)
                + " (" + comparisons + " comps)");
    }

    public static void main(String[] args) {
        int[] risks = {10, 25, 50, 100};

        // Linear Search (unsorted)
        linearSearch(risks, 30);

        // Binary Search (sorted array required)
        Arrays.sort(risks);
        System.out.println("Sorted risks: " + Arrays.toString(risks));
        binaryFloorCeiling(risks, 30);
    }
}
