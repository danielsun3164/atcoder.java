package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答2Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "2 3", "6");
	}

	@Test
	void case2() {
		check("20 3\n" + "5 6\n" + "3 4\n" + "1 2", "458752");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/H");
	}
}
