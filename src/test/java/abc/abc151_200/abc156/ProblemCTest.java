package abc.abc151_200.abc156;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 4", "5");
	}

	@Test
	void case2() {
		check("7\n" + "14 14 2 13 56 2 37", "2354");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC156/C");
	}
}
