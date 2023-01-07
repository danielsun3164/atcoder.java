package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem066Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 10E-7d;

	@Test
	void case1() {
		checkResultIsAbout("2\n" + "1 2\n" + "1 2", 0.25d, TOLERANCE);
	}

	@Test
	void case2() {
		checkResultIsAbout("3\n" + "3 3\n" + "1 1\n" + "4 4", 1.0d, TOLERANCE);
	}

	@Test
	void case3() {
		checkResultIsAbout("10\n" + "1 10\n" + "38 40\n" + "8 87\n" + "2 9\n" + "75 100\n" + "45 50\n" + "89 92\n"
				+ "27 77\n" + "23 88\n" + "62 81", 13.696758921226d, TOLERANCE);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/066", TOLERANCE);
	}
}
