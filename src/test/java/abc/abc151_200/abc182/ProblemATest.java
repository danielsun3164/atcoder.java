package abc.abc151_200.abc182;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("200 300", "200");
	}

	@Test
	void case2() {
		check("10000 0", "20100");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC182/A");
	}
}
