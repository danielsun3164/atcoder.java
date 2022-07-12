package abc.abc101_150.abc126;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "1 2 1", "2");
	}

	@Test
	void case2() {
		check("6 5\n" + "1 2 1\n" + "2 3 2\n" + "1 3 3\n" + "4 5 4\n" + "5 6 5", "2");
	}

	@Test
	void case3() {
		check("100000 1\n" + "1 100000 100", "99999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC126/E");
	}
}
