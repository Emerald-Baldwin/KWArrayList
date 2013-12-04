/*Name: Emerald Baldwin
  Assignment: Lab 3
  Title: KWArrayList.java
  Course: CSCE 270
  Lab Section: Lab 2
  Semester: Fall 2013
  Instructor: Kenneth Blaha
  Date: 10/01/13
  Sources consulted: Dr. Blaha, Java API
  Program description: This program is similar to ArrayList, just lacking some methods.
  This program allows the list to contain null items, and toString, remove(item), 
  contains(item), indexOf(item), lastIndextOf(item) work correctly.
  Note: I did not implement the methods above the "Implement these methods" bar
  */

import java.util.Arrays;
import java.util.AbstractList;



/**
 * This class implements some of the methods of the Java
 *  ArrayList class.
 *  @author Koffman, Wolfgang, &DB
 */
public class KWArrayList<E>       
{
	// Data Fields

	/** The default initial capacity */
	private static final int INITIAL_CAPACITY = 10;
	/** The underlying data array */
	private E[] theData;
	/** The current size */
	private int size = 0;
	/** The current capacity */
	private int capacity = 0;

	/**
	 * Construct an empty KWArrayList with the default
	 * initial capacity
	 */
	@SuppressWarnings("unchecked")
	public KWArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}


	/**
	 * Add an entry at the end of the list
	 * @param anEntry - The value to be inserted at the end of the list
	 */
	public boolean add(E anEntry) {
		if (size == capacity) {
			reallocate();
		}
		theData[size] = anEntry;
		size++;
		return true;
	}

	/**
	 * Remove an entry based on its index
	 * @param index - The index of the entry to be removed
	 * @return The value removed
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;
		return returnValue;
	}

	/**
	 * Get a value in the array based on its index.
	 * @param index - The index of the item desired
	 * @return The contents of the array at that index
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}


	/**
	 * Get the current size of the array
	 * @return The current size of the array
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns a string representation of this collection. The string 
	 * representation consists of a list of 
	 * the collection's elements order, enclosed in square brackets 
	 * ("[]"). Adjacent elements are 
	 * separated by the characters ", " 
	 * (comma and space).  
	 * This is the string representation returned by Java's ArrayList	 
	 * @return a string representation of the collection
	 */ 
	public String toString(){
		StringBuilder s = new StringBuilder("[");
		for (int i=0; i<size-1; i++){
			if (theData[i] == null)
				s.append("null, ");
			else
				s.append(theData[i]+", ");
		}
		if (size>0)
			s.append(theData[size-1]);
		s.append("]");
		return s.toString();
	}

	/**
	 * Allocate a new array to hold the directory
	 */
	private void reallocate() {
		capacity = 2 * capacity;
		theData = Arrays.copyOf(theData, capacity);
	}



	/**************************************************************/
	/**************Implement The Following Methods ****************/
	/**************************************************************/

	/**
	 * Construct an empty KWArrayList with a specified initial capacity
	 * @param capacity The initial capacity
	 */
	@SuppressWarnings("unchecked")
	public KWArrayList(int capacity) {
		theData = (E[]) new Object[capacity];
		this.capacity = capacity;
	}


	/**
	 * Removes all of the elements from this list (optional operation). 
	 * The list will be empty after this call returns.
	 */
	public void clear() {
		size = 0;
	}


	/**
	 * Set the value in the array based on its index.
	 * @param index - The index of the item desired
	 * @param newValue - The new value to store at this position
	 * @return The old value at this position
	 * @throws ArrayIndexOutOfBoundsException - if the index
	 *         is negative or if it is greater than or equal to the
	 *         current size
	 */
	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}


	/**
	 * Add an entry to the data inserting it before the
	 * item at the specified index.
	 * @param index - The index of the time that the new
	 *        value it to be inserted in front of.
	 * @param theValue - The value to be inserted
	 * @throws ArrayIndexOUtOfBoundsException if index is
	 *         less than zero or greater than size
	 */
	public boolean add(int index, E anEntry) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (size == capacity) {
			reallocate();
		}
		
		//Shift data in elements from index to size - 1
		for (int i = size; i > index; i--) {
			theData[i] = theData[i - 1];
		}
		
		//Insert the new item
		theData[index] = anEntry;
		size++;
		return true;
	} 


	/**
	 * Returns the index of the first occurrence of the specified element 
	 * in this list, or -1 if this list does not contain the element.  
	 * @param item the item we are looking for
	 * @return the index of the first occurrence of the specified element 
	 *       in this list, or -1 if this list does not contain the element
	 */
	public int indexOf(E item) {
		if (item == null) {
			for (int j = 0; j < size; j++) {
				if (theData[j] == null)
					return j;
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				if (item.equals(theData[i]))
					return i;
			}
		}
		return -1;
	}


	/**
	 * Returns true if this list contains the specified element. More 
	 * formally, returns true if and only if this list contains at least one 
	 * element e such that (item==null ? e==null : item.equals(e)).
	 * @param item  element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(E item) {
		if (indexOf(item) != -1) {
			return  true;
		}
		return false;
	}


	/**
	 * Returns true if this list contains no elements and false otherwise.
	 * @return true if this list contains no elements and false otherwise.
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}


	/**
	 * Returns the index of the last occurrence of the specified 
	 * element in this list, or -1 if this list does not contain the 
	 * element.  
	 * @param item element to search for
	 * @return the index of the last occurrence of the specified element in 
	 * 		this list, or -1 if this list does not contain the element
	 */
	public int lastIndexOf(E item) {
		if (item == null) {
			for (int j = size - 1; j >= 0; j--) {
				if (theData[j] == null)
					return j;
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (item.equals(theData[i]))
					return i;
			}
		}
		return -1;
	}

	/**
	 * Remove the first occurrence of element item.
	 * @param item The item to be removed
	 * @return true if item is found and removed; otherwise, return false.
	 */
	public boolean remove(E item) {
		int index = indexOf(item);
		if (index != -1) {
			for (int i = index; i <= size - 2; i++) {
				theData[i] = theData[i + 1];
			}
			size--;
			return true;
		}
		return false;
	}
}

