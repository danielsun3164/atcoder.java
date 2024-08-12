package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答2Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2 3", "1" + LF + "2");
	}

	@Test
	void case2() {
		check("11 5\n" + "3 7 2 5 11 6 1 9 8 10 4",
				"2" + LF + "3" + LF + "3" + LF + "5" + LF + "6" + LF + "7" + LF + "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/D");
	}
}
