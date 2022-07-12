package abc.abc101_150.abc150;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "1000000000", "999999993");
	}

	@Test
	void case2() {
		check("2\n" + "5 8", "124");
	}

	@Test
	void case3() {
		check("5\n" + "52 67 72 25 79", "269312");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC150/E");
	}
}
