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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SitePage;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.time.api.Time;
import org.sakaiproject.time.api.TimeService;
import org.sakaiproject.tool.api.ToolManager;

@RunWith(MockitoJUnitRunner.class)
public class ExampleLogicImplTest {
	private static final String FULL_TIME = "Dec 11, 2010 4:55 PM EST";
	private static final String CURRENT_SITE_ID = "current-site-id";

	@Mock
	private TimeService timeService;
	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private ToolManager toolManager;
	@Mock
	private SiteService siteService;
	@Mock
	private Time time;
	@Mock
	private Site site;

	private ExampleLogicImpl exampleLogic;
	private List<SitePage> sitePages;

	@Before
	public void setUp() throws Exception {
		// setup time service & time
		when(timeService.newTime()).thenReturn(time);
		when(time.toStringLocalFullZ()).thenReturn(FULL_TIME);

		// setup tool manager
		when(toolManager.getCurrentPlacement().getContext()).thenReturn(CURRENT_SITE_ID);

		// setup site service & site
		when(siteService.getSite(CURRENT_SITE_ID)).thenReturn(site);
		sitePages = new ArrayList<SitePage>();
		for (int i = 0; i < 5; i++) {
			SitePage page = mock(SitePage.class);
			when(page.getTitle()).thenReturn("Page " + i);
			sitePages.add(page);
		}
		when(site.getPages()).thenReturn(sitePages);

		exampleLogic = new ExampleLogicImpl();
		exampleLogic.setTimeService(timeService);
		exampleLogic.setToolManager(toolManager);
		exampleLogic.setSiteService(siteService);
	}

	@Test
	public void getTime() {
		String now = exampleLogic.getNow();
		assertNotNull(now);
		Assert.assertEquals(FULL_TIME, now);
	}

	@Test
	public void getPages() {
		List<SitePage> pages = exampleLogic.getPages();
		assertNotNull(pages);
		assertEquals(pages.size(), sitePages.size());
		for (int i = 0; i < pages.size(); i++) {
			assertEquals("Page " + i, pages.get(i).getTitle());
		}
	}
}
