package abc.abc051_100.abc087;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1234\n" + "150\n" + "100", "84");
	}

	@Test
	void case2() {
		check("1000\n" + "108\n" + "108", "28");
	}

	@Test
	void case3() {
		check("579\n" + "123\n" + "456", "0");
	}

	@Test
	void case4() {
		check("7477\n" + "549\n" + "593", "405");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC090/A");
	}
}
