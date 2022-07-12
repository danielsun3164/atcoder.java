package abc.abc151_200.abc170;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("6 3\n" + "8 1\n" + "6 2\n" + "9 3\n" + "1 1\n" + "2 2\n" + "1 3\n" + "4 3\n" + "2 1\n" + "1 2",
				"6" + LF + "2" + LF + "6");
	}

	@Test
	void case2() {
		check("2 2\n" + "4208 1234\n" + "3056 5678\n" + "1 2020\n" + "2 2020", "3056" + LF + "4208");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC170/E");
	}
}
