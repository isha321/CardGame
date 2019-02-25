//Isha Sinha
//CSC 311
class Cards{
    public String Suit;
    public Cards next;
	public int Number;
	public int suitValue;

    public Cards(String S, int N)
    {
       Suit=S;
	   Number=N;
	   next=null;
	   if (S.equals("Clubs")) {
		   suitValue = 1;
	   }

	   else if (S.equals("Diamonds")) {
		   suitValue = 2;
	   }

	   else if (S.equals("Hearts")) {
		   suitValue = 3;
	   }

	   else if (S.equals("Spades")) {
		   suitValue = 4;
	   }
	}

	public String toString() {
		return Number + " of " + Suit;
	}

}
