/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ha;

/**
 *
 * @author Markus
 * @param <T>
 */
public class MySortedList<T> extends MyList implements Comparable<T>{

    @Override
    public void insert(Object e) {
        this.sortedInsert(e);
    }   

    public void sortedInsert(Comparable e) {
        if (this.length() > 0) {
            MyListElement current = firstElement;
            if (current.getMyElement() != null) {
                while (current.getMyElement() != null && current.getnextMyElement() != null) {
                    if (current.getnextMyElement().getMyElement() == null) {
                        if (current.getMyListElement().compareTo(e) > 0) {
                            this.insert(e);
                        } else {
                            this.append(e);
                        }
                        break;
                    }
                    if (current.getMyListElement().compareTo(e) <= 0 && current.getnextMyElement().getMyListElement().compareTo(e) >= 0) {
                        MyListElement element = (MyListElement) e;
                        element.setnextMyElement(current.getnextMyElement());
                        element.setprevMyElement(current);
                        current.setnextMyElement(element);
                        element.getnextMyElement().setprevMyElement(element);
                        break;
                    }
                    
                    current = current.getnextMyElement();
                }    
            } 
        } else {
            throw new IndexOutOfBoundsException("Liste hat noch keine Elemente!");
        }
    }
    
    @Override
    public void append(Object e) {
        throw new UnsupportedOperationException("Append ist nicht zugelassen für Sortierte Listen.");
    }
    
    @Override
    public int compareTo(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}