package abc.abc001_050.abc050;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 1 4\n" + "2\n" + "1 1\n" + "2 3", "6" + LF + "9");
	}

	@Test
	void case2() {
		check("5\n" + "7 2 3 8 5\n" + "3\n" + "4 2\n" + "1 7\n" + "4 13", "19" + LF + "25" + LF + "30");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC066/B");
	}
}
