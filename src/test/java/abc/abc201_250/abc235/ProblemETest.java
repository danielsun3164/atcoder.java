package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5 6 3\n" + "1 2 2\n" + "2 3 3\n" + "1 3 6\n" + "2 4 5\n" + "4 5 9\n" + "3 5 8\n" + "1 3 1\n" + "3 4 7\n"
				+ "3 5 7", "Yes" + LF + "No" + LF + "Yes");
	}

	@Test
	void case2() {
		check("2 3 2\n" + "1 2 100\n" + "1 2 1000000000\n" + "1 1 1\n" + "1 2 2\n" + "1 1 5", "Yes" + LF + "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/E");
	}
}
