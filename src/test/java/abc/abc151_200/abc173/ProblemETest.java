package abc.abc151_200.abc173;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "1 2 -3 -4", "12");
	}

	@Test
	void case2() {
		check("4 3\n" + "-1 -2 -3 -4", "1000000001");
	}

	@Test
	void case3() {
		check("2 1\n" + "-1 1000000000", "1000000000");
	}

	@Test
	void case4() {
		check("10 10\n" + "1000000000 100000000 10000000 1000000 100000 10000 1000 100 10 1", "999983200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC173/E");
	}
}
