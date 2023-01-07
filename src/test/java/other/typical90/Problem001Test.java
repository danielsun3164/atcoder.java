package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem001Test extends TestBase {

	@Test
	void case1() {
		check("3 34\n" + "1\n" + "8 13 26", "13");
	}

	@Test
	void case2() {
		check("7 45\n" + "2\n" + "7 11 16 20 28 34 38", "12");
	}

	@Test
	void case3() {
		check("3 100\n" + "1\n" + "28 54 81", "46");
	}

	@Test
	void case4() {
		check("3 100\n" + "2\n" + "28 54 81", "26");
	}

	@Test
	void case5() {
		check("20 1000\n" + "4\n" + "51 69 102 127 233 295 350 388 417 466 469 523 553 587 720 739 801 855 926 954",
				"170");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/001");
	}
}
