package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("7 14\n" + "1 6 3\n" + "1 4 1\n" + "1 5 2\n" + "1 2 7\n" + "1 3 5\n" + "3 2\n" + "3 4\n" + "3 6\n"
				+ "2 3 5\n" + "2 4 1\n" + "1 1 5\n" + "3 2\n" + "3 4\n" + "3 6",
				"5 6 3 5 2 7\n" + "2 4 1\n" + "5 6 3 5 2 7\n" + "4 1 5 2 7\n" + "1 4\n" + "2 6 3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/D");
	}
}
