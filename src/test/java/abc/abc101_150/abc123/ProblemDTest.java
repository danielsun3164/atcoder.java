package abc.abc101_150.abc123;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2 2 8\n" + "4 6\n" + "1 5\n" + "3 8",
				"19" + LF + "17" + LF + "15" + LF + "14" + LF + "13" + LF + "12" + LF + "10" + LF + "8");
	}

	@Test
	void case2() {
		check("3 3 3 5\n" + "1 10 100\n" + "2 20 200\n" + "1 10 100",
				"400" + LF + "310" + LF + "310" + LF + "301" + LF + "301");
	}

	@Test
	void case3() {
		check("10 10 10 20\n"
				+ "7467038376 5724769290 292794712 2843504496 3381970101 8402252870 249131806 6310293640 6690322794 6082257488\n"
				+ "1873977926 2576529623 1144842195 1379118507 6003234687 4925540914 3902539811 3326692703 484657758 2877436338\n"
				+ "4975681328 8974383988 2882263257 7690203955 514305523 6679823484 4263279310 585966808 3752282379 620585736",
				"23379871545" + LF + "22444657051" + LF + "22302177772" + LF + "22095691512" + LF + "21667941469" + LF
						+ "21366963278" + LF + "21287912315" + LF + "21279176669" + LF + "21160477018" + LF
						+ "21085311041" + LF + "21059876163" + LF + "21017997739" + LF + "20703329561" + LF
						+ "20702387965" + LF + "20590247696" + LF + "20383761436" + LF + "20343962175" + LF
						+ "20254073196" + LF + "20210218542" + LF + "20150096547");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC123/D");
	}
}
