package abc.abc151_200.abc194;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "0 0 1", "1");
	}

	@Test
	void case2() {
		check("3 2\n" + "1 1 1", "0");
	}

	@Test
	void case3() {
		check("3 2\n" + "0 1 0", "2");
	}

	@Test
	void case4() {
		check("7 3\n" + "0 0 1 2 0 1 0", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC194/E");
	}
}
