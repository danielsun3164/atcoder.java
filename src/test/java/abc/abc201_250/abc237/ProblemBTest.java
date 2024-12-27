package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2 3\n" + "4 5 6\n" + "7 8 9\n" + "10 11 12", "1 4 7 10" + LF + "2 5 8 11" + LF + "3 6 9 12");
	}

	@Test
	void case2() {
		check("2 2\n" + "1000000000 1000000000\n" + "1000000000 1000000000",
				"1000000000 1000000000" + LF + "1000000000 1000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/B");
	}
}
