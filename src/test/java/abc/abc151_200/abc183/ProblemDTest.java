package abc.abc151_200.abc183;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 10\n" + "1 3 5\n" + "2 4 4\n" + "3 10 6\n" + "2 4 1", "No");
	}

	@Test
	void case2() {
		check("4 10\n" + "1 3 5\n" + "2 4 4\n" + "3 10 6\n" + "2 3 1", "Yes");
	}

	@Test
	void case3() {
		check("6 1000000000\n" + "0 200000 999999999\n" + "2 20 1\n" + "20 200 1\n" + "200 2000 1\n" + "2000 20000 1\n"
				+ "20000 200000 1", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC183/D");
	}
}
