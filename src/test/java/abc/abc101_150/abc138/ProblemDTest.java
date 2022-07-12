package abc.abc101_150.abc138;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2\n" + "2 3\n" + "2 4\n" + "2 10\n" + "1 100\n" + "3 1", "100 110 111 110");
	}

	@Test
	void case2() {
		check("6 2\n" + "1 2\n" + "1 3\n" + "2 4\n" + "3 6\n" + "2 5\n" + "1 10\n" + "1 10", "20 20 20 20 20 20");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC138/D");
	}
}
