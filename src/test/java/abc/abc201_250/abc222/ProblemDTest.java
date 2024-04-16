package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 1\n" + "2 3", "5");
	}

	@Test
	void case2() {
		check("3\n" + "2 2 2\n" + "2 2 2", "1");
	}

	@Test
	void case3() {
		check("10\n" + "1 2 3 4 5 6 7 8 9 10\n" + "1 4 9 16 25 36 49 64 81 100", "978222082");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/D");
	}
}
