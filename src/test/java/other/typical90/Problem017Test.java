package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem017Test extends TestBase {

	@Test
	void case1() {
		check("6 3\n" + "2 5\n" + "1 4\n" + "1 3", "2");
	}

	@Test
	void case2() {
		check("250 10\n" + "13 218\n" + "17 99\n" + "24 180\n" + "53 115\n" + "96 97\n" + "111 158\n" + "124 164\n"
				+ "135 227\n" + "158 177\n" + "204 224", "10");
	}

	@Test
	void case3() {
		check("100 10\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5\n" + "1 6\n" + "1 7\n" + "1 8\n" + "1 9\n" + "1 10\n"
				+ "1 11", "0");
	}

	@Test
	void case4() {
		check("100 10\n" + "1 100\n" + "2 99\n" + "3 98\n" + "4 97\n" + "5 96\n" + "6 95\n" + "7 94\n" + "8 93\n"
				+ "9 92\n" + "10 91", "0");
	}

	@Test
	void case5() {
		check("1000 40\n" + "12 43\n" + "23 59\n" + "32 118\n" + "44 751\n" + "68 136\n" + "70 168\n" + "85 328\n"
				+ "88 809\n" + "92 981\n" + "95 540\n" + "98 772\n" + "98 903\n" + "125 896\n" + "173 737\n"
				+ "199 325\n" + "212 369\n" + "227 587\n" + "230 374\n" + "287 442\n" + "306 926\n" + "314 858\n"
				+ "316 371\n" + "318 493\n" + "337 506\n" + "384 887\n" + "387 493\n" + "394 457\n" + "404 652\n"
				+ "414 527\n" + "422 920\n" + "441 730\n" + "445 620\n" + "468 602\n" + "482 676\n" + "568 857\n"
				+ "587 966\n" + "653 757\n" + "710 928\n" + "764 927\n" + "778 916", "229");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/017");
	}
}
