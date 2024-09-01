package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("6 7\n" + "1 2\n" + "1 4\n" + "1 5\n" + "2 4\n" + "2 3\n" + "3 5\n" + "3 6",
				"1" + LF + "2" + LF + "3" + LF + "2" + LF + "1" + LF + "0");
	}

	@Test
	void case2() {
		check("8 7\n" + "7 8\n" + "3 4\n" + "5 6\n" + "5 7\n" + "5 8\n" + "6 7\n" + "6 8",
				"3" + LF + "2" + LF + "2" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/E");
	}
}
