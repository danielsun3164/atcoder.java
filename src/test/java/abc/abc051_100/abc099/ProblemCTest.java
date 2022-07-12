package abc.abc051_100.abc099;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("127", "4");
	}

	@Test
	void case2() {
		check("3", "3");
	}

	@Test
	void case3() {
		check("44852", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC099/C");
	}
}
