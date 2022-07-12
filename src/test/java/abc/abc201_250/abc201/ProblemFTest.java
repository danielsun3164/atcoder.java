package abc.abc201_250.abc201;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 1 2\n" + "9 3 5\n" + "8 6 4\n" + "9 4 6", "6");
	}

	@Test
	void case2() {
		check("6\n" + "2 6 5 3 4 1\n" + "10 8 16\n" + "30 2 10\n" + "10 17 8\n" + "11 27 22\n" + "8 6 5\n" + "15 29 2",
				"15");
	}

	@Test
	void case3() {
		check("9\n" + "3 8 4 7 6 9 1 5 2\n" + "7976 3696 9706\n" + "768 8807 8521\n" + "1133 8683 7120\n"
				+ "1189 3331 2259\n" + "900 7451 1159\n" + "6126 2639 7107\n" + "5540 8253 2891\n" + "8417 4220 9091\n"
				+ "8732 1417 1540", "15865");
	}

	@Test
	void case4() {
		check("12\n" + "11 9 1 12 2 7 3 5 10 4 6 8\n" + "3960 3158 9029\n" + "6521 6597 7581\n" + "5688 2299 2123\n"
				+ "4946 4298 9122\n" + "394 4350 9142\n" + "3098 7151 2039\n" + "8525 3758 6155\n" + "6970 3658 9353\n"
				+ "9780 1778 3608\n" + "6065 5562 923\n" + "9701 5524 6482\n" + "9395 6016 705", "20637");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc201/F");
	}
}
