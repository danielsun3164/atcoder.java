package abc.abc101_150.abc140;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "4 2 3 1", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + "1 2 3 1", "Yes");
	}

	@Test
	void case3() {
		check("1\n" + "1 1", "No");
	}

	@Test
	void case4() {
		check("5\n" + "4 3 5 3 1 2 7 8 7 4 6 3 7 2 3 6 2 7 3 2 6 7 3 4 6 7 3 4 2 5 2 3", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC140/F");
	}
}
