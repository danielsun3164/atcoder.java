package abc.abc001_050.abc047;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "100 50 200", "1");
	}

	@Test
	void case2() {
		check("5 8\n" + "50 30 40 10 20", "2");
	}

	@Test
	void case3() {
		check("10 100\n" + "7 10 4 5 9 3 6 8 2 1", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC063/D");
	}
}
