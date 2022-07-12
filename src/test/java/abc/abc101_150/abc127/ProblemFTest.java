package abc.abc101_150.abc127;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 4 2\n" + "2\n" + "1 1 -8\n" + "2", "4 2" + LF + "1 -3");
	}

	@Test
	void case2() {
		check("4\n" + "1 -1000000000 1000000000\n" + "1 -1000000000 1000000000\n" + "1 -1000000000 1000000000\n" + "2",
				"-1000000000 3000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC127/F");
	}
}
