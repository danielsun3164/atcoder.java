package abc.abc151_200.abc169;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("198 1.10", "217");
	}

	@Test
	void case2() {
		check("1 0.01", "0");
	}

	@Test
	void case3() {
		check("1000000000000000 9.99", "9990000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC169/C");
	}
}
