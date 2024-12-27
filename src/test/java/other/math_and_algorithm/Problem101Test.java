package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem101Test extends TestBase {

	@Test
	void case1() {
		check("1", "1");
	}

	@Test
	void case2() {
		check("2", "3" + LF + "2");
	}

	@Test
	void case3() {
		check("3", "7" + LF + "4" + LF + "3");
	}

	@Test
	void case4() {
		check("4", "15" + LF + "7" + LF + "5" + LF + "4");
	}

	@Test
	void case5() {
		check("7", "127" + LF + "33" + LF + "18" + LF + "13" + LF + "10" + LF + "8" + LF + "7");
	}

	@Test
	void case6() {
		check("20",
				"1048575" + LF + "17710" + LF + "2744" + LF + "906" + LF + "430" + LF + "250" + LF + "167" + LF + "118"
						+ LF + "90" + LF + "75" + LF + "65" + LF + "56" + LF + "48" + LF + "41" + LF + "35" + LF + "30"
						+ LF + "26" + LF + "23" + LF + "21" + LF + "20");
	}

	@Test
	void case7() {
		check("50", "898961330" + LF + "951279874" + LF + "262271567" + LF + "14341526" + LF + "1985602" + LF + "466851"
				+ LF + "153365" + LF + "63191" + LF + "30623" + LF + "16687" + LF + "9987" + LF + "6453" + LF + "4354"
				+ LF + "3070" + LF + "2290" + LF + "1790" + LF + "1427" + LF + "1138" + LF + "910" + LF + "735" + LF
				+ "605" + LF + "512" + LF + "448" + LF + "405" + LF + "375" + LF + "350" + LF + "326" + LF + "303" + LF
				+ "281" + LF + "260" + LF + "240" + LF + "221" + LF + "203" + LF + "186" + LF + "170" + LF + "155" + LF
				+ "141" + LF + "128" + LF + "116" + LF + "105" + LF + "95" + LF + "86" + LF + "78" + LF + "71" + LF
				+ "65" + LF + "60" + LF + "56" + LF + "53" + LF + "51" + LF + "50");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/015");
	}
}
