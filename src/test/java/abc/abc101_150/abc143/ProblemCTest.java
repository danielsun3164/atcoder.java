package abc.abc101_150.abc143;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "aabbbbaaca", "5");
	}

	@Test
	void case2() {
		check("5\n" + "aaaaa", "1");
	}

	@Test
	void case3() {
		check("20\n" + "xxzaffeeeeddfkkkkllq", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC143/C");
	}
}
