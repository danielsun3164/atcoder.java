package abc.abc051_100.abc095;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 1000\n" + "120\n" + "100\n" + "140", "9");
	}

	@Test
	void case2() {
		check("4 360\n" + "90\n" + "90\n" + "90\n" + "90", "4");
	}

	@Test
	void case3() {
		check("5 3000\n" + "150\n" + "130\n" + "150\n" + "130\n" + "110", "26");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC096/B");
	}
}
