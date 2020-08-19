package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "unagi 20\n" + "usagi 13\n" + "snuke 42\n" + "smeke 7", "snuke");
	}

	@Test
	void case2() {
		check("5\n" + "a 10\n" + "b 20\n" + "c 30\n" + "d 40\n" + "e 100", "atcoder");
	}

	@Test
	void case3() {
		check("14\n" + "yasuzuka 3340\n" + "uragawara 4032\n" + "oshima 2249\n" + "maki 2614\n" + "kakizaki 11484\n"
				+ "ogata 10401\n" + "kubiki 9746\n" + "yoshikawa 5142\n" + "joetsu 100000\n" + "nakago 4733\n"
				+ "itakura 7517\n" + "kiyosato 3152\n" + "sanwa 6190\n" + "nadachi 3169", "joetsu");
	}
}
