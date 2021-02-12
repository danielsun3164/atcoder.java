package other.joisc2007;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * http://hydra.nat.uni-magdeburg.de/packing/csq/csq22.html のデータを使用
 */
public class ProblemO_Packing4 {

	public static void main(String[] args) {
		int[][] result = new int[][] { { 10566530, 10566530 }, { 31699589, 10566530 }, { 52832648, 10566530 },
				{ 89433470, 10566530 }, { 71133059, 21135406 }, { 10566530, 31699589 }, { 31699589, 31699589 },
				{ 52832648, 31704282 }, { 89433470, 31704283 }, { 71133059, 42273159 }, { 31704282, 52832648 },
				{ 10566530, 52832648 }, { 89433470, 52842035 }, { 52837334, 52850147 }, { 68139396, 68139396 },
				{ 21135406, 71133059 }, { 42797404, 71446006 }, { 89433470, 73975094 }, { 10566530, 89433470 },
				{ 31704283, 89433470 }, { 53890525, 89433470 }, { 75023585, 89433470 } };
		for (int[] a : result) {
			System.out.println(Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
	}
}
