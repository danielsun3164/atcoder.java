package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 9 5\n" + "4 8 5\n" + "5 7 5", "8");
	}

	@Test
	void case2() {
		check("3\n" + "5 9 5\n" + "6 8 5\n" + "7 7 5", "-1");
	}

	@Test
	void case3() {
		check("10\n" + "158260522 877914575 602436426\n" + "24979445 861648772 623690081\n"
				+ "433933447 476190629 262703497\n" + "211047202 971407775 628894325\n"
				+ "731963982 822804784 450968417\n" + "430302156 982631932 161735902\n"
				+ "880895728 923078537 707723857\n" + "189330739 910286918 802329211\n"
				+ "404539679 303238506 317063340\n" + "492686568 773361868 125660016", "861648772");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/B");
	}
}
