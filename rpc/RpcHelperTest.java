package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder one = new ItemBuilder();
		one.setItemId("one");
		one.setRating(5);
		one.setCategories(category);
		Item on = one.build();
		ItemBuilder two = new ItemBuilder();
		two.setItemId("one");
		two.setRating(5);
		two.setCategories(category);
		Item tw = two.build();
		//Item one = new ItemBuilder().setItemId("one").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
		//Item two = new ItemBuilder().setItemId("two").setLatitude(33.33).setRating(5).setCategories(category).setLongitude(33.33).build();
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(on);
		listItem.add(tw);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(on.toJSONObject());
		jsonArray.put(tw.toJSONObject());
		
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}


