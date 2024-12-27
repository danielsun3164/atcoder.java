package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答2Test extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "1 2 3 4 5\n" + "1 4\n" + "2 1\n" + "2 5\n" + "3 2\n" + "1 2\n" + "2 1", "4" + LF + "5");
	}

	@Test
	void case2() {
		check("6 2\n" + "10 10 10 9 8 8\n" + "1 4\n" + "2 1\n" + "2 5\n" + "3 2\n" + "6 4\n" + "1 4\n" + "2 2",
				"9" + LF + "10");
	}

	@Test
	void case3() {
		check("4 4\n" + "1 10 100 1000\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 4\n" + "2 3\n" + "3 2\n" + "4 1",
				"1" + LF + "10" + LF + "100" + LF + "1000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/E");
	}
}
