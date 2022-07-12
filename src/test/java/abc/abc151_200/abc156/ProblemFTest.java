package abc.abc151_200.abc156;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "3 1 4\n" + "5 3 2", "1");
	}

	@Test
	void case2() {
		check("7 3\n" + "27 18 28 18 28 46 1000000000\n" + "1000000000 1 7\n" + "1000000000 2 10\n" + "1000000000 3 12",
				"224489796" + LF + "214285714" + LF + "559523809");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC156/F");
	}
}
