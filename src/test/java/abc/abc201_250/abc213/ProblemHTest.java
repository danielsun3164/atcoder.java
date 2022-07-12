package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3 2 2\n" + "1 2\n" + "1 0\n" + "1 3\n" + "2 0", "5");
	}

	@Test
	void case2() {
		check("3 3 4\n" + "1 2\n" + "3 0 0 0\n" + "1 3\n" + "0 1 0 0\n" + "2 3\n" + "2 0 0 0", "130");
	}

	@Test
	void case3() {
		check("2 1 5\n" + "1 2\n" + "31415 92653 58979 32384 62643", "844557977");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/H");
	}
}
