// jUnit test for KWArrayList.java. This was only the third or fourth week in
// the fall 2013 term. Thus, it may have some unnecessary code

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KWArrayListTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testToString() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add(null);
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add(null);
		System.out.println(disney.toString());
	}

	@Test
	public void testKWArrayListInt() {
		KWArrayList<String> disney = new KWArrayList<String>(5);
		disney.add("George");
		disney.add("Fred");
		disney.add("Ron");
		assertEquals(3, disney.size());
		System.out.println(disney.toString());
	}

	@Test
	public void testClear() {
		KWArrayList<Integer> nums = new KWArrayList<Integer>();
		nums.add(12);
		nums.add(13);
		nums.clear();
		assertEquals(0, nums.size());
	}

	@Test
	public void testSet() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.set(0, "Pluto");
		assertEquals("Pluto", disney.get(0));
	}

	@Test
	public void testAddIntE() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add("Pluto");
		disney.add(2, "Barb");
		assertEquals("Minnie", disney.get(3));
		assertEquals("Barb", disney.get(2));
	}

	@Test
	public void testIndexOf() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add("Pluto");
		disney.add(null);
		assertEquals(1, disney.indexOf("Goofy"));
		assertEquals(4, disney.indexOf(null));
		assertEquals(3, disney.indexOf("Pluto"));
	}

	@Test
	public void testContains() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add("Pluto");
		assertEquals(true, disney.contains("Minnie"));
		assertEquals(false, disney.contains("bob"));
	}

	@Test
	public void testIsEmpty() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add("Pluto");
		assertEquals(false, disney.isEmpty());
		KWArrayList<String> a = new KWArrayList<String>();
		assertEquals(true, a.isEmpty());
	}

	@Test
	public void testLastIndexOf() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add(null);
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add("Pluto");
		disney.add("Mickey");
		disney.add(null);
		disney.add("Toontown");
		assertEquals(5, disney.lastIndexOf("Mickey"));
		assertEquals(6, disney.lastIndexOf(null));
	}

	@Test
	public void testRemoveE() {
		KWArrayList<String> disney = new KWArrayList<String>();
		disney.add("Mickey");
		disney.add("Goofy");
		disney.add("Minnie");
		disney.add(null);
		disney.add("Pluto");
		disney.add("Toontown");
		disney.remove("Pluto");
		assertEquals(true, disney.remove(null));
		assertEquals("Toontown", disney.get(3));
	}

}
