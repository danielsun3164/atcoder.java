package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem037Test extends TestBase {

	@Test
	void case1() {
		check("100 4\n" + "30 40 120\n" + "30 40 30\n" + "30 40 1500\n" + "30 40 40", "1660");
	}

	@Test
	void case2() {
		check("100 4\n" + "13 15 31415\n" + "12 13 92653\n" + "29 33 58979\n" + "95 98 32384", "-1");
	}

	@Test
	void case3() {
		check("5000 5\n" + "1000 1000 1000000000\n" + "1000 1000 1000000000\n" + "1000 1000 1000000000\n"
				+ "1000 1000 1000000000\n" + "1000 1000 1000000000", "5000000000");
	}

	@Test
	void case4() {
		check("10000 20\n" + "4539 6002 485976\n" + "1819 5162 457795\n" + "1854 2246 487643\n" + "1023 4733 393530\n"
				+ "1052 6274 289577\n" + "1874 2436 167747\n" + "1457 4248 452660\n" + "2103 4189 174955\n"
				+ "3057 5061 319316\n" + "4898 4953 394627\n" + "1313 2880 154687\n" + "1274 1364 259598\n"
				+ "3866 5844 233027\n" + "1163 5036 386223\n" + "1234 4630 155972\n" + "2845 4978 442858\n"
				+ "3168 5368 171601\n" + "3708 4407 394899\n" + "3924 4122 428313\n" + "2112 4169 441976", "2727026");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/037");
	}
}
