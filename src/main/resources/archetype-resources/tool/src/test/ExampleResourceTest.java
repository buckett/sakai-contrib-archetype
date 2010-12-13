/*
 * Copyright 2010 Sakai Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.osedu.org/licenses/ECL-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package ${package};

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.sakaiproject.site.api.SitePage;

@RunWith(MockitoJUnitRunner.class)
public class ExampleResourceTest {
	private static final String FULL_TIME = "Saturday, December 11, 2010 4:55:48 PM EST";

	@Mock
	private ExampleLogic exampleLogic;

	private ExampleResource resource;
	private List<SitePage> sitePages;

	@Before
	public void setUp() {
		when(exampleLogic.getNow()).thenReturn(FULL_TIME);

		sitePages = new ArrayList<SitePage>();
		for (int i = 0; i < 5; i++) {
			SitePage page = mock(SitePage.class);
			when(page.getTitle()).thenReturn("Page " + i);
			sitePages.add(page);
		}
		when(exampleLogic.getPages()).thenReturn(sitePages);

		resource = new ExampleResource();
		resource.setExampleLogic(exampleLogic);
	}

	@Test
	public void getTimestamp() throws Exception {
		JSONObject json = resource.getTimestamp();
		assertNotNull(json);
		assertTrue(json.has("timestamp"));
		String timestamp = json.getString("timestamp");
		assertNotNull(timestamp);
		assertEquals(FULL_TIME, timestamp);
	}

	@Test
	public void getPages() throws Exception {
		JSONObject json = resource.getPages();
		assertNotNull(json);
		assertTrue(json.has("pages"));
		JSONArray pages = json.getJSONArray("pages");
		assertNotNull(pages);
		assertEquals(sitePages.size(), pages.length());
		for (int i = 0; i < pages.length(); i++) {
			assertEquals("Page " + i, pages.get(i));
		}
	}

	@Test
	public void getEmptyPages() throws Exception {
		sitePages.clear();
		JSONObject json = resource.getPages();
		assertNotNull(json);
		assertTrue(json.has("pages"));
		JSONArray pages = json.getJSONArray("pages");
		assertNotNull(pages);
		assertEquals(sitePages.size(), pages.length());
	}
}
