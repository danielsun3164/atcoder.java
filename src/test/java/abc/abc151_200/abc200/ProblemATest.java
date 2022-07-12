package abc.abc151_200.abc200;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2021", "21");
	}

	@Test
	void case2() {
		check("200", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc200/A");
	}
}
