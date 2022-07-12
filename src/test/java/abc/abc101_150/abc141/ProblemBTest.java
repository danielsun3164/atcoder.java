package abc.abc101_150.abc141;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("RUDLUDR", "Yes");
	}

	@Test
	void case2() {
		check("DULL", "No");
	}

	@Test
	void case3() {
		check("UUUUUUUUUUUUUUU", "Yes");
	}

	@Test
	void case4() {
		check("ULURU", "No");
	}

	@Test
	void case5() {
		check("RDULULDURURLRDULRLR", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC141/B");
	}
}
