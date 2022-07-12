package abc.abc151_200.abc200;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 5", "1 2 2");
	}

	@Test
	void case2() {
		check("1000000 1000000000000000000", "1000000 1000000 1000000");
	}

	@Test
	void case3() {
		check("9 47", "3 1 4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc200/E");
	}
}
