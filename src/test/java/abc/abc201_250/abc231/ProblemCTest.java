package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "100 160 130\n" + "120", "2");
	}

	@Test
	void case2() {
		check("5 5\n" + "1 2 3 4 5\n" + "6\n" + "5\n" + "4\n" + "3\n" + "2",
				"0" + LF + "1" + LF + "2" + LF + "3" + LF + "4");
	}

	@Test
	void case3() {
		check("5 5\n" + "804289384 846930887 681692778 714636916 957747794\n" + "424238336\n" + "719885387\n"
				+ "649760493\n" + "596516650\n" + "189641422", "5" + LF + "3" + LF + "5" + LF + "5" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/C");
	}
}
