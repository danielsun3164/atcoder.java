package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "1 1 2 1", "3");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 1 2", "1");
	}

	@Test
	void case3() {
		check("10 4\n" + "2 7 1 8 2 8 1 8 2 8", "132");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/Ex");
	}
}
