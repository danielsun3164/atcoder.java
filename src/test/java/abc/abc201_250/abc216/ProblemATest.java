package abc.abc201_250.abc216;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("15.8", "15+");
	}

	@Test
	void case2() {
		check("1.0", "1-");
	}

	@Test
	void case3() {
		check("12.5", "12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/A");
	}
}
