package abc.abc151_200.abc152;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3 4", "13");
	}

	@Test
	void case2() {
		check("5\n" + "12 12 12 12 12", "5");
	}

	@Test
	void case3() {
		check("3\n" + "1000000 999999 999998", "996989508");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC152/E");
	}
}
