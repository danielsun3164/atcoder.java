package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemC別回答Test extends TestBase {

	@Test
	void case1() {
		check("4", "203");
	}

	@Test
	void case2() {
		check("2", "25");
	}

	@Test
	void case3() {
		check("1000000", "248860093");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/C");
	}
}
