package abc.abc101_150.abc148;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3", "6");
	}

	@Test
	void case2() {
		check("123 456", "18696");
	}

	@Test
	void case3() {
		check("100000 99999", "9999900000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC148/C");
	}
}
