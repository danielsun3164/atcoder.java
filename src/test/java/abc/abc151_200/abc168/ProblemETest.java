package abc.abc151_200.abc168;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "-1 1\n" + "2 -1", "5");
	}

	@Test
	void case2() {
		check("10\n" + "3 2\n" + "3 2\n" + "-1 1\n" + "2 -1\n" + "-3 -9\n" + "-8 12\n" + "7 7\n" + "8 1\n" + "8 2\n"
				+ "8 4", "479");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/E");
	}
}
