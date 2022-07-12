package abc.abc001_050.abc049;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3 1\n" + "1 2\n" + "2 3\n" + "3 4\n" + "2 3", "1 2 2 1");
	}

	@Test
	void case2() {
		check("4 2 2\n" + "1 2\n" + "2 3\n" + "1 4\n" + "2 3", "1 2 2 1");
	}

	@Test
	void case3() {
		check("7 4 4\n" + "1 2\n" + "2 3\n" + "2 5\n" + "6 7\n" + "3 5\n" + "4 5\n" + "3 4\n" + "6 7", "1 1 2 1 2 2 2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC065/D");
	}
}
