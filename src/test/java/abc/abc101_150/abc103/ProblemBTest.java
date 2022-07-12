package abc.abc101_150.abc103;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("kyoto\n" + "tokyo", "Yes");
	}

	@Test
	void case2() {
		check("abc\n" + "arc", "No");
	}

	@Test
	void case3() {
		check("aaaaaaaaaaaaaaab\n" + "aaaaaaaaaaaaaaab", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC103/B");
	}
}
