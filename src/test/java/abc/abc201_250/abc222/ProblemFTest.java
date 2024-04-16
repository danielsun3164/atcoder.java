package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 2\n" + "2 3 3\n" + "1 2 3", "8" + LF + "6" + LF + "6");
	}

	@Test
	void case2() {
		check("6\n" + "1 2 3\n" + "1 3 1\n" + "1 4 4\n" + "1 5 1\n" + "1 6 5\n" + "9 2 6 5 3 100",
				"105" + LF + "108" + LF + "106" + LF + "109" + LF + "106" + LF + "14");
	}

	@Test
	void case3() {
		check("6\n" + "1 2 1000000000\n" + "2 3 1000000000\n" + "3 4 1000000000\n" + "4 5 1000000000\n"
				+ "5 6 1000000000\n" + "1 2 3 4 5 6",
				"5000000006" + LF + "4000000006" + LF + "3000000006" + LF + "3000000001" + LF + "4000000001" + LF
						+ "5000000001");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/F");
	}
}
