package a_random_word_generator;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import java.security.SecureRandom;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Character[]consonantChars = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};

		char[]vowelChars = {'a','e','i','o','u','y'};


		/**
		 * the length of the word chosen at random
		 */
		int consonants = 2 + new SecureRandom().nextInt(6);
		int vowels = 1 + new SecureRandom().nextInt(4);

		/**
		 * the arrayLists to hold the vowels and the consonants
		 */

		ArrayList<Character>consonantList = new ArrayList<>();
		ArrayList<Character>vowelList = new ArrayList<>();

		/**
		 * randomly select consontants and vowels into the respective arrayLists
		 * the number of the selected letters is dependent on the size of the
		 * <variable>consonants</variable> and <variable>vowels</variable>
		 */

		for(int i = 0; i < consonants;i++)
			consonantList.add(consonantChars[new SecureRandom().nextInt(20)]);

		for(int i = 0; i < vowels; i++)
			vowelList.add(vowelChars[new SecureRandom().nextInt(6)]);

		/**
		 * an arrayList to merge the <arrayList>consonantList</arrayList> and
		 * <arrayList>vowelList</arrayList> into one arrayList
		 */

		ArrayList<Character>merged = new ArrayList<>();
		merged.addAll(vowelList);
		merged.addAll(consonantList);

		/**
		 *  shuffle the content the <arrayList>merged</arrayList>
		 * content and put them in a new arrayList
		 */

		/*
		ArrayList<Character> shuffled = new ArrayList<>();
		shuffled.ensureCapacity(merged.size()); //set the size of <arrayList>shuffled</arrayList> as that of
		//<arrayList>merged></arrayList>
		*/

		char[	]shuffled = new char[merged.size()	];

		for(char each:merged)
		{
			int space = new SecureRandom().nextInt(merged.size());//the index of the <arrayList>shuffled
			//</arrayList> where a character is going to be put

			while(shuffled[space] != 0) space = new SecureRandom().nextInt(merged.size());

			//after an empty index is found , set its content to be the value contained in each
			shuffled[space	] = each;

		}

		/**
		 * print out the content of <arrayList>shuffled</arrayList>
		 */
		for(char each:shuffled)
			System.out.print(each);

	}
	

}
