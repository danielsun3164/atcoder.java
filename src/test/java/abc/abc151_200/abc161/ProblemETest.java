package abc.abc151_200.abc161;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("11 3 2\n" + "ooxxxoxxxoo", "6");
	}

	@Test
	void case2() {
		check("5 2 3\n" + "ooxoo", "1" + LF + "5");
	}

	@Test
	void case3() {
		checkResultIsEmpty("5 1 0\n" + "ooooo");
	}

	@Test
	void case4() {
		check("16 4 3\n" + "ooxxoxoxxxoxoxxo", "11" + LF + "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC161/E");
	}
}
