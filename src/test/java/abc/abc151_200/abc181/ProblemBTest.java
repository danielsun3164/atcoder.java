package abc.abc151_200.abc181;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 3\n" + "3 5", "18");
	}

	@Test
	void case2() {
		check("3\n" + "11 13\n" + "17 47\n" + "359 44683", "998244353");
	}

	@Test
	void case3() {
		check("1\n" + "1 1000000", "500000500000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC181/B");
	}
}
