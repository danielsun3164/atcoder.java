package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abc\n" + "ijk", "Yes");
	}

	@Test
	void case2() {
		check("z\n" + "a", "Yes");
	}

	@Test
	void case3() {
		check("ppq\n" + "qqp", "No");
	}

	@Test
	void case4() {
		check("atcoder\n" + "atcoder", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/B");
	}
}
