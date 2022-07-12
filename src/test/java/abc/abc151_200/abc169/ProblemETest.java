package abc.abc151_200.abc169;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 2\n" + "2 3", "3");
	}

	@Test
	void case2() {
		check("3\n" + "100 100\n" + "10 10000\n" + "1 1000000000", "9991");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC169/E");
	}
}
