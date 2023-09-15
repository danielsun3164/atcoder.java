package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答2Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "-2 10\n" + "3 10\n" + "12 10", "11");
	}

	@Test
	void case2() {
		check("5\n" + "0 1000000000\n" + "0 1000000000\n" + "1 1000000000\n" + "2 1000000000\n" + "3 1000000000",
				"4999999994");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/H");
	}
}
