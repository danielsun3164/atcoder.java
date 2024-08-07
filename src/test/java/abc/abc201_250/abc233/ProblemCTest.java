package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 40\n" + "3 1 8 4\n" + "2 10 5", "2");
	}

	@Test
	void case2() {
		check("3 200\n" + "3 10 10 10\n" + "3 10 10 10\n" + "5 2 2 2 2 2", "45");
	}

	@Test
	void case3() {
		check("3 1000000000000000000\n" + "2 1000000000 1000000000\n" + "2 1000000000 1000000000\n"
				+ "2 1000000000 1000000000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/C");
	}
}
