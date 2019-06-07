package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "1148-1210\n" + "1323-1401\n" + "1106-1123\n" + "1129-1203");
		ProblemD.main(null);
		assertResultIs("1105-1210" + LF + "1320-1405");
	}

	@Test
	void test_Case2() {
		in.input("1\n" + "0000-2400");
		ProblemD.main(null);
		assertResultIs("0000-2400");
	}

	@Test
	void test_Case3() {
		in.input("6\n" + "1157-1306\n" + "1159-1307\n" + "1158-1259\n" + "1230-1240\n" + "1157-1306\n" + "1315-1317");
		ProblemD.main(null);
		assertResultIs("1155-1310" + LF + "1315-1320");
	}
}
