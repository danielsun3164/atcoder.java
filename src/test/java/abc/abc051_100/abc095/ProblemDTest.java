package abc.abc051_100.abc095;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 20\n" + "2 80\n" + "9 120\n" + "16 1", "191");
	}

	@Test
	void case2() {
		check("3 20\n" + "2 80\n" + "9 1\n" + "16 120", "192");
	}

	@Test
	void case3() {
		check("1 100000000000000\n" + "50000000000000 1", "0");
	}

	@Test
	void case4() {
		check("15 10000000000\n" + "400000000 1000000000\n" + "800000000 1000000000\n" + "1900000000 1000000000\n"
				+ "2400000000 1000000000\n" + "2900000000 1000000000\n" + "3300000000 1000000000\n"
				+ "3700000000 1000000000\n" + "3800000000 1000000000\n" + "4000000000 1000000000\n"
				+ "4100000000 1000000000\n" + "5200000000 1000000000\n" + "6600000000 1000000000\n"
				+ "8000000000 1000000000\n" + "9300000000 1000000000\n" + "9700000000 1000000000", "6500000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC096/D");
	}
}
