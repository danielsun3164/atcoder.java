package abc.abc101_150.abc145;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 60\n" + "10 10\n" + "100 100", "110");
	}

	@Test
	void case2() {
		check("3 60\n" + "10 10\n" + "10 20\n" + "10 30", "60");
	}

	@Test
	void case3() {
		check("3 60\n" + "30 10\n" + "30 20\n" + "30 30", "50");
	}

	@Test
	void case4() {
		check("10 100\n" + "15 23\n" + "20 18\n" + "13 17\n" + "24 12\n" + "18 29\n" + "19 27\n" + "23 21\n" + "18 20\n"
				+ "27 15\n" + "22 25", "145");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC145/E");
	}
}
