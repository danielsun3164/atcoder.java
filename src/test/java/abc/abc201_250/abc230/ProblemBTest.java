package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("xoxxoxxo", "Yes");
	}

	@Test
	void case2() {
		check("xxoxxoxo", "No");
	}

	@Test
	void case3() {
		check("ox", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/B");
	}
}
