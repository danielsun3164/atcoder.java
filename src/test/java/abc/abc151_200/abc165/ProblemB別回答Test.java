package abc.abc151_200.abc165;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemB別回答Test extends TestBase {

	@Test
	void case1() {
		check("103", "3");
	}

	@Test
	void case2() {
		check("1000000000000000000", "3760");
	}

	@Test
	void case3() {
		check("1333333333", "1706");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC165/B");
	}
}
