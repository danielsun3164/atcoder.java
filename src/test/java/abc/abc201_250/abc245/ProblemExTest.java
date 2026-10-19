package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("2 3 6", "5");
	}

	@Test
	void case2() {
		check("10 0 2", "1023");
	}

	@Test
	void case3() {
		check("1000000000 20220326 1000000000000", "561382653");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/Ex");
	}
}
