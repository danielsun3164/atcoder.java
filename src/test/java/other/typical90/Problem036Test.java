package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem036Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "-1 2\n" + "1 1\n" + "-2 -3\n" + "1\n" + "2\n" + "3", "6" + LF + "7" + LF + "7");
	}

	@Test
	void case2() {
		check("5 3\n" + "-2 -2\n" + "-1 -1\n" + "0 0\n" + "1 1\n" + "2 2\n" + "5\n" + "3\n" + "1",
				"8" + LF + "4" + LF + "8");
	}

	@Test
	void case3() {
		check("2 1\n" + "-1000000000 -1000000000\n" + "1000000000 1000000000\n" + "1", "4000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/036");
	}
}
