package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem065Test extends TestBase {

	@Test
	void case1() {
		check("3 1 2 5\n" + "4 2 4", "2");
	}

	@Test
	void case2() {
		check("65 6 12 35\n" + "30 18 35", "257190020");
	}

	@Test
	void case3() {
		check("23502 65936 72385 95835\n" + "72759 85735 72385", "229429276");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/065");
	}
}
