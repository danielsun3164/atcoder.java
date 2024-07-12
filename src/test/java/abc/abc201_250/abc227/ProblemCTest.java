package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4", "5");
	}

	@Test
	void case2() {
		check("100", "323");
	}

	@Test
	void case3() {
		check("100000000000", "5745290566750");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/C");
	}
}
