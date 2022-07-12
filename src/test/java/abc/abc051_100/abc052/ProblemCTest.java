package abc.abc051_100.abc052;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3", "4");
	}

	@Test
	void case2() {
		check("6", "30");
	}

	@Test
	void case3() {
		check("1000", "972926972");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC067/C");
	}
}
