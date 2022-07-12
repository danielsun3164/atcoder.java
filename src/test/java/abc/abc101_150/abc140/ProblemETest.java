package abc.abc101_150.abc140;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3 1", "5");
	}

	@Test
	void case2() {
		check("5\n" + "1 2 3 4 5", "30");
	}

	@Test
	void case3() {
		check("8\n" + "8 2 7 3 4 5 6 1", "136");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC140/E");
	}
}
