package abc.abc151_200.abc173;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1900", "100");
	}

	@Test
	void case2() {
		check("3000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC173/A");
	}
}
