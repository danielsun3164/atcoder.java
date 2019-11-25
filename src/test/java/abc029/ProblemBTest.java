package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("january\n" + "february\n" + "march\n" + "april\n" + "may\n" + "june\n" + "july\n" + "august\n"
				+ "september\n" + "october\n" + "november\n" + "december");
		ProblemB.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("rrrrrrrrrr\n" + "srrrrrrrrr\n" + "rsr\n" + "ssr\n" + "rrs\n" + "srsrrrrrr\n" + "rssrrrrrr\n" + "sss\n"
				+ "rrr\n" + "srr\n" + "rsrrrrrrrr\n" + "ssrrrrrrrr");
		ProblemB.main(null);
		assertResultIs("11");
	}
}
