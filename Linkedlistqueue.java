//Isha Sinha 
//CSC 311
public class Linkedlistqueue
{
    private Cards head;
    private int size;

    public Linkedlistqueue()
    {
        head = new Cards("head",0);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public Cards getCards(int index){                         //need a helper getnode() method
        if(index < 0 || index > size)
            return null;
        Cards iter = head;
        //Use a loop to iterate over the lise, and go to the index
        for (int i = 0; i < index; i++){
            iter = iter.next;
        }
        return iter;
    }

    public Cards peek() {
        Cards iter = head.next;
        return iter;
    }

    public void offer(Cards x){                   //adds item at the end of the list
        Cards end = getCards(size);                //gets hold of the last node
		x.next = end.next;
		end.next = x;
        size++;
    }

    public Cards poll(){
        if(size == 0)
            return null;
        Cards removed = head.next;
        head.next = removed.next;
        size--;
        return removed;
    }

    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public int checkCards() {
        Cards iter = head.next;
        Cards best = iter;
        int winningPlayer = 1;
        for (int i = 1; i < size; i++) {
            iter = iter.next;
            if (iter.Number > best.Number) {
                best = iter;
                winningPlayer = i + 1;
            }
            else if (iter.Number == best.Number) {
                if (iter.suitValue < best.suitValue) {
                    best = iter;
                    winningPlayer = i + 1;
                }
            }
        }
        return winningPlayer;
    }

    public void printList(){
        Cards temp = head;
        System.out.println("Data: ");
        while(temp.next != null){
            System.out.print(temp.next.Number + " of " + temp.next.Suit + " -> ");
            temp = temp.next;
        }
        System.out.println("");
    }

    //public void printReverse(Cards head){
      //  if(head.next == null){
         //   System.out.println(head.data + "<--");
            //return;
        //}
        //printReverse(head.next);
        //System.out.print(head.data + "<--");
    //}
//}
}
