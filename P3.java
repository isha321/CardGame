//Isha Sinha 
//CSC 311 
import java.util.Random;
public class P3
{
	public static void main(String[] args)
    {
		Linkedlistqueue p1 = new Linkedlistqueue(); //making players
		Linkedlistqueue p2 = new Linkedlistqueue();
		Linkedlistqueue p3 = new Linkedlistqueue();
		Linkedlistqueue p4 = new Linkedlistqueue();

		Cards [] deck = new Cards [52];
		deck = makeDeck(deck);

		for(int i = 0; i < 13; i++) {			
			p1.offer(deck[i]);
			p2.offer(deck[i + 13]);
			p3.offer(deck[i + 26]);
			p4.offer(deck[i + 39]);
		}

		play(p1,p2,p3,p4);
	}

	public static Cards [] makeDeck(Cards [] deck) {				//method to make the deck of cards
		Cards[] clubs = new Cards[13];  //club cards
        Cards[] diamonds = new Cards[13]; //diamond cards
        Cards[] hearts = new Cards[13]; //heart cards
        Cards[] spades = new Cards[13]; //spade cards

		for (int i = 0; i < 13; i++)    //cards get created
        {
            clubs[i] =  new Cards("Clubs", (i + 1));
            spades[i] = new Cards("Spades", (i + 1));
            hearts[i] = new Cards( "Hearts", (i + 1));
            diamonds[i] = new Cards("Diamonds", (i + 1));
        }

		for (int i = 0; i < 13; i++)    //cards get created
        {
			deck[i] = clubs[i];
			deck[i + 13] = spades[i];
			deck[i + 26] = hearts[i];
			deck[i + 39] = diamonds[i];
        }

		//Reference: http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array			//to shuffle card array
        int index;
        Cards temp;
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }

		return deck;
	}

	public static void play(Linkedlistqueue p1, Linkedlistqueue p2, Linkedlistqueue p3, Linkedlistqueue p4) {	//creating the rounds
		Linkedlistqueue table = new Linkedlistqueue();
		int round = 1;
		while (!p1.isEmpty() && !p2.isEmpty() && !p3.isEmpty() && !p4.isEmpty()) {
			System.out.println("Round " + round + "!");
			System.out.println("Player 1 deals " + p1.peek());
			System.out.println("Player 2 deals " + p2.peek());
			System.out.println("Player 3 deals " + p3.peek());
			System.out.println("Player 4 deals " + p4.peek());
			table.offer(p1.poll());
			table.offer(p2.poll());
			table.offer(p3.poll());
			table.offer(p4.poll());

			int winningPlayer = table.checkCards();
			if (winningPlayer == 1) {
				System.out.println("Player 1 collects!");
				for (int i = 0; i < 4; i++) {
					p1.offer(table.poll());
				}
			}
			else if (winningPlayer == 2){
				System.out.println("Player 2 collects!");
				for (int i = 0; i < 4; i++) {
					p2.offer(table.poll());
				}
			}

			else if (winningPlayer == 3){
				System.out.println("Player 3 collects!");
				for (int i = 0; i < 4; i++) {
					p3.offer(table.poll());
				}
			}

			else if (winningPlayer == 4){
				System.out.println("Player 4 collects!");
				for (int i = 0; i < 4; i++) {
					p4.offer(table.poll());
				}
			}
			round++;
			if (round > 15) {
				break;
			}
		}
		gameOver(p1,p2,p3,p4);
	}

	public static void gameOver(Linkedlistqueue p1, Linkedlistqueue p2, Linkedlistqueue p3, Linkedlistqueue p4) {		//when the game is over 
		System.out.println("Game over!");
		int [] results = new int [4];
		results[0] = p1.getSize();
		results[1] = p2.getSize();
		results[2] = p3.getSize();
		results[3] = p4.getSize();
		int max = 0;
		int winner = 0;
		int tieCounter = 0;

		System.out.println("Results: ");				//results are printed out
		for(int i = 0; i < results.length; i++) {
			System.out.println("Player " + (i+1) + ": " + results[i]);
		}

		for(int i = 0; i < results.length; i++) {
			if (results[i] > max) {
				max = results[i];
				winner = i + 1;
			}
		}

		for(int i = 0; i < results.length; i++) {
			if (max == results[i]) {
				tieCounter++;
			}
		}

		if (tieCounter > 1) {
			System.out.println("Tie game!");
		}
		else {
			System.out.println("Winner is Player " + winner + "!");
		}
	}
}
