package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 1\n" + "1 3\n" + "1 1\n" + "-1 -1", "3");
	}

	@Test
	void case2() {
		check("20\n" + "224 433\n" + "987654321 987654321\n" + "2 0\n" + "6 4\n" + "314159265 358979323\n" + "0 0\n"
				+ "-123456789 123456789\n" + "-1000000000 1000000000\n" + "124 233\n" + "9 -6\n" + "-4 0\n" + "9 5\n"
				+ "-7 3\n" + "333333333 -333333333\n" + "-9 -1\n" + "7 -10\n" + "-1 5\n" + "324 633\n"
				+ "1000000000 -1000000000\n" + "20 0", "1124");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/C");
	}
}
