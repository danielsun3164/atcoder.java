package abc.abc151_200.abc160;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("sippuu", "Yes");
	}

	@Test
	void case2() {
		check("iphone", "No");
	}

	@Test
	void case3() {
		check("coffee", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC160/A");
	}
}
