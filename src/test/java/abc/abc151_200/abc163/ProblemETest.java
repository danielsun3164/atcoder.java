package abc.abc151_200.abc163;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 3 4 2", "20");
	}

	@Test
	void case2() {
		check("6\n" + "5 5 6 1 1 1", "58");
	}

	@Test
	void case3() {
		check("6\n" + "8 6 9 1 2 1", "85");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC163/E");
	}
}
