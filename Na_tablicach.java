package bst;

import java.util.Scanner;

public class Na_tablicach {

	public static void wyswietl(Integer[] tab) {

		for (int i = 0; i < tab.length; i++)
			if (tab[i] != null)
				System.out.print(tab[i] + " ");
			else
				System.out.print(" - ");
	}

	public static Integer[] przypisz(Integer[] tab, int l, int indeks) {

		int n = (2 * indeks) + 2;

		if (n > tab.length) {

			Integer[] tab_L = new Integer[n];
			for (int i = 0; i < tab.length; i++)
				tab_L[i] = tab[i];
			return tab_L;
		}

		else
			return tab;
	}

	public static Integer[] porownaj(Integer[] tab, int l) {

		int x = 0;
		boolean czy_null = false;
		while (!czy_null) {

			if (l > tab[x]) {

				x = (2 * x) + 2;

				if (x >= tab.length)
					tab = przypisz(tab, l, x);

				if (tab[x] == null) {
					czy_null = true;
					tab[x] = l;
				}
			}

			else {

				x = (2 * x) + 1;

				if (x >= tab.length)
					tab = przypisz(tab, l, x);

				if (tab[x] == null) {
					czy_null = true;
					tab[x] = l;
				}
			}
		}
		return tab;
	}

	public static void main(String[] args) {

		Integer[] tab = new Integer[1];

		Scanner liczba = new Scanner(System.in);

		int l = liczba.nextInt();
		tab[0] = l;

		tab = przypisz(tab, l, 0);

		while (true) {

			l = liczba.nextInt();

			tab = porownaj(tab, l);

			wyswietl(tab);
		}
	}
}
