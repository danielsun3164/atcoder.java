package abc.abc051_100.abc070;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("575", "Yes");
	}

	@Test
	void case2() {
		check("123", "No");
	}

	@Test
	void case3() {
		check("812", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC070/A");
	}
}
