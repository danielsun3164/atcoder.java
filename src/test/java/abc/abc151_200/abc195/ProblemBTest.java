package abc.abc151_200.abc195;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("100 200 2", "10 20");
	}

	@Test
	void case2() {
		check("120 150 2", "14 16");
	}

	@Test
	void case3() {
		check("300 333 1", "UNSATISFIABLE");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC195/B");
	}
}
