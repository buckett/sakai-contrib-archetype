/**********************************************************************************
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/
package ${package};

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SitePage;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.time.api.TimeService;
import org.sakaiproject.tool.api.Placement;
import org.sakaiproject.tool.api.ToolManager;

/**
 * Component implmentation of the ExampleLogic interface.
 */
public class ExampleLogicImpl implements ExampleLogic {
	private static final Log log = LogFactory.getLog(ExampleLogicImpl.class);

	// ---------- dependency injection ----------
	private TimeService timeService;
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	private ToolManager toolManager;
	public void setToolManager(ToolManager toolManager) {
		this.toolManager = toolManager;
	}

	private SiteService siteService;
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	// ---------- initialization ----------
	public void init() {
	}

	// ---------- ExampleLogic interface ----------
	/**
	 * {@inheritDoc}
	 */
	public String getNow() {
		return timeService.newTime().toStringLocalFullZ();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<SitePage> getPages() {
		ArrayList<SitePage> pages = new ArrayList<SitePage>();
		Site site = getCurrentSite();
		if (site != null) {
			pages.addAll(site.getPages());
		}
		return pages;
	}

	// ---------- internal methods ----------
	/**
	 * Get the current site.
	 */
	private Site getCurrentSite() {
		Placement placement = toolManager.getCurrentPlacement();
		String locationId = placement.getContext();
		Site site = null;
		try {
			site = siteService.getSite(locationId);
		} catch (IdUnusedException e) {
			log.error("Cannot get the info about locationId: " + locationId);
		}
		return site;
	}
}
