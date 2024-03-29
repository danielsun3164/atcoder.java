package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 2 3\n" + "1 2 1 3\n" + "2 3 3 5\n" + "1 1 5\n" + "2 2 3\n" + "1 3 2", "2 3" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("8 10 10\n" + "4 3 329982133 872113932\n" + "6 8 101082040 756263297\n" + "4 7 515073851 793074419\n"
				+ "8 7 899017043 941751547\n" + "5 7 295510441 597348810\n" + "7 2 688716395 890599546\n"
				+ "6 1 414221915 748470452\n" + "6 4 810915860 904512496\n" + "3 1 497469654 973509612\n"
				+ "4 1 307142272 872178157\n" + "374358788 4 509276232\n" + "243448834 6 585993193\n"
				+ "156350864 4 682491610\n" + "131643541 8 836902943\n" + "152874385 6 495945159\n"
				+ "382276121 1 481368090\n" + "552433623 2 884584430\n" + "580376205 2 639442239\n"
				+ "108790644 7 879874292\n" + "883275610 1 994982498",
				"4" + LF + "6 1" + LF + "4 1" + LF + "8" + LF + "6 1" + LF + "1" + LF + "2" + LF + "2" + LF + "7 2" + LF
						+ "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/F");
	}
}
