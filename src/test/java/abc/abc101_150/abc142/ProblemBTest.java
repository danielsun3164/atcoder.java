package abc.abc101_150.abc142;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 150\n" + "150 140 100 200", "2");
	}

	@Test
	void case2() {
		check("1 500\n" + "499", "0");
	}

	@Test
	void case3() {
		check("5 1\n" + "100 200 300 400 500", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC142/B");
	}
}
