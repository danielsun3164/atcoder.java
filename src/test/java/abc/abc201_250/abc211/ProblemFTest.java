package abc.abc201_250.abc211;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4\n" + "1 2 1 4 3 4 3 2\n" + "4\n" + "2 5 2 3 5 3 5 5\n" + "4\n" + "5 6 5 5 3 5 3 6\n" + "3\n"
				+ "1 4\n" + "2 3\n" + "4 5", "0" + LF + "2" + LF + "1");
	}

	@Test
	void case2() {
		check("2\n" + "4\n" + "12 3 12 5 0 5 0 3\n" + "12\n" + "1 1 1 9 10 9 10 0 4 0 4 6 6 6 6 2 8 2 8 7 2 7 2 1\n"
				+ "4\n" + "2 6\n" + "4 4\n" + "6 3\n" + "1 8", "0" + LF + "2" + LF + "1" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc211/F");
	}
}
