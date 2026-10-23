package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3\n" + "2 1 3", "3");
	}

	@Test
	void case2() {
		check("5\n" + "2 3 5 4 1\n" + "4 2 1 3 5", "12");
	}

	@Test
	void case3() {
		check("8\n" + "1 2 3 4 5 6 7 8\n" + "1 2 3 4 5 6 7 8", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/F");
	}
}
