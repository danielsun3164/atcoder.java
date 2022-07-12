package abc.abc101_150.abc121;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 5\n" + "4 9\n" + "2 4", "12");
	}

	@Test
	void case2() {
		check("4 30\n" + "6 18\n" + "2 5\n" + "3 10\n" + "7 9", "130");
	}

	@Test
	void case3() {
		check("1 100000\n" + "1000000000 100000", "100000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC121/C");
	}
}
