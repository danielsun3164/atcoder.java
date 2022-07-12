package abc.abc051_100.abc067;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "3 6\n" + "1 2\n" + "3 1\n" + "7 4\n" + "5 7\n" + "1 4", "Fennec");
	}

	@Test
	void case2() {
		check("4\n" + "1 4\n" + "4 2\n" + "2 3", "Snuke");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC078/D");
	}
}
