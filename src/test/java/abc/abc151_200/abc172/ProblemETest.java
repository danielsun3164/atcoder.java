package abc.abc151_200.abc172;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2", "2");
	}

	@Test
	void case2() {
		check("2 3", "18");
	}

	@Test
	void case3() {
		check("141421 356237", "881613484");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC172/E");
	}
}
