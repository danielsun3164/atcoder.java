package abc.abc101_150.abc123;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "2\n" + "4\n" + "3\n" + "5", "7");
	}

	@Test
	void case2() {
		check("10\n" + "123\n" + "123\n" + "123\n" + "123\n" + "123", "5");
	}

	@Test
	void case3() {
		check("10000000007\n" + "2\n" + "3\n" + "5\n" + "7\n" + "11", "5000000008");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC123/C");
	}
}
