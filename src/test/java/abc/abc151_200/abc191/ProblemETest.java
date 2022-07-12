package abc.abc151_200.abc191;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2 5\n" + "2 3 10\n" + "3 1 15\n" + "4 3 20", "30" + LF + "30" + LF + "30" + LF + "-1");
	}

	@Test
	void case2() {
		check("4 6\n" + "1 2 5\n" + "1 3 10\n" + "2 4 5\n" + "3 4 10\n" + "4 1 10\n" + "1 1 10",
				"10" + LF + "20" + LF + "30" + LF + "20");
	}

	@Test
	void case3() {
		check("4 7\n" + "1 2 10\n" + "2 3 30\n" + "1 4 15\n" + "3 4 25\n" + "3 4 20\n" + "4 3 20\n" + "4 3 30",
				"-1" + LF + "-1" + LF + "40" + LF + "40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC191/E");
	}
}
