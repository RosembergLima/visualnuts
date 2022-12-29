package pt.visualnuts.challenge1;

import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		CheckNumber check = new CheckNumber();
		IntStream.range(0, 100).forEach(
				nbr -> {
					if(check.isDivisible(3, nbr) && check.isDivisible(5, nbr))
						System.out.println("Visual Nuts");
					else if (check.isDivisible(3, nbr))
						System.out.println("Visual");
					else if (check.isDivisible(5, nbr))
						System.out.println("Nuts");
					else
						System.out.println(nbr);
				}
			);


	}

}
