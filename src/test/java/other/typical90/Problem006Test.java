package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem006Test extends TestBase {

	@Test
	void case1() {
		check("7 3\n" + "atcoder", "acd");
	}

	@Test
	void case2() {
		check("14 5\n" + "kittyonyourlap", "inlap");
	}

	@Test
	void case3() {
		check("22 5\n" + "competitiveprogramming", "aming");
	}

	@Test
	void case4() {
		check("22 10\n" + "competitiveprogramming", "ceegamming");
	}

	@Test
	void case5() {
		check("22 22\n" + "competitiveprogramming", "competitiveprogramming");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/006");
	}
}
