package abc.abc151_200.abc172;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("cupofcoffee\n" + "cupofhottea", "4");
	}

	@Test
	void case2() {
		check("abcde\n" + "bcdea", "5");
	}

	@Test
	void case3() {
		check("apple\n" + "apple", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC172/B");
	}
}
