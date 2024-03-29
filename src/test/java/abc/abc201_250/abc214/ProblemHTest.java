package abc.abc201_250.abc214;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("5 5 2\n" + "1 2\n" + "2 3\n" + "3 2\n" + "1 4\n" + "1 5\n" + "1 4 5 2 8", "18");
	}

	@Test
	void case2() {
		check("3 1 10\n" + "2 3\n" + "1 100 100", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc214/H");
	}
}
