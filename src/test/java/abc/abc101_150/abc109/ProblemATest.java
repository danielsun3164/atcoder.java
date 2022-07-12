package abc.abc101_150.abc109;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1", "Yes");
	}

	@Test
	void case2() {
		check("1 2", "No");
	}

	@Test
	void case3() {
		check("2 2", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC109/A");
	}
}
