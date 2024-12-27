package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("2 1", "2");
	}

	@Test
	void case2() {
		check("2 39", "12");
	}

	@Test
	void case3() {
		check("3 2", "250000004");
	}

	@Test
	void case4() {
		check("2392 39239", "984914531");
	}

	@Test
	void case5() {
		check("1000000000 1000000000", "776759630");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/Ex");
	}
}
