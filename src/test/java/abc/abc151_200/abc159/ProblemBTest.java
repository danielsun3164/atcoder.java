package abc.abc151_200.abc159;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("akasaka", "Yes");
	}

	@Test
	void case2() {
		check("level", "No");
	}

	@Test
	void case3() {
		check("atcoder", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC159/B");
	}
}
