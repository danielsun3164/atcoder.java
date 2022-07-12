package abc.abc051_100.abc098;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "aabbca", "2");
	}

	@Test
	void case2() {
		check("10\n" + "aaaaaaaaaa", "1");
	}

	@Test
	void case3() {
		check("45\n" + "tgxgdqkyjzhyputjjtllptdfxocrylqfqjynmfbfucbir", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC098/B");
	}
}
