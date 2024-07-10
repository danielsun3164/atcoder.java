package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 0\n" + "5 1 1\n" + "7 1 1", "10");
	}

	@Test
	void case2() {
		check("5\n" + "1000000000 0\n" + "1000000000 0\n" + "1000000000 0\n" + "1000000000 0\n"
				+ "1000000000 4 1 2 3 4", "5000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/C");
	}
}
