package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "1 4\n" + "1 3\n" + "1 2\n" + "1 1\n" + "3\n" + "2\n" + "1 0\n" + "2", "1" + LF + "2");
	}

	@Test
	void case2() {
		check("9\n" + "1 5\n" + "1 5\n" + "1 3\n" + "2\n" + "3\n" + "2\n" + "1 6\n" + "3\n" + "2",
				"5" + LF + "3" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/E");
	}
}
