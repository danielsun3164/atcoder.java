package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem073Test extends TestBase {

	@Test
	void case1() {
		check("7\n" + "b a b a b b a\n" + "2 1\n" + "3 7\n" + "3 2\n" + "3 4\n" + "5 4\n" + "4 6", "4");
	}

	@Test
	void case2() {
		check("2\n" + "a b\n" + "1 2", "1");
	}

	@Test
	void case3() {
		check("22\n" + "b a b b a b b b a b a a a a b b a b b a a a\n" + "1 7\n" + "4 14\n" + "12 22\n" + "2 4\n"
				+ "21 17\n" + "3 20\n" + "7 8\n" + "20 14\n" + "15 11\n" + "8 14\n" + "9 12\n" + "17 8\n" + "6 20\n"
				+ "11 20\n" + "18 19\n" + "10 8\n" + "22 20\n" + "13 21\n" + "5 14\n" + "19 20\n" + "16 14", "16");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/073");
	}
}
