package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("5 3 2\n" + "1 3", "7");
	}

	@Test
	void case2() {
		check("6 6 1\n" + "4", "120");
	}

	@Test
	void case3() {
		check("99 10 3\n" + "10 50 90", "761621047");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/H");
	}
}
