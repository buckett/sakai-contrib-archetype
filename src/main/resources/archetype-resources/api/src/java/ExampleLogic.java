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

import java.util.List;

import org.sakaiproject.site.api.SitePage;

/**
 * Example logic component class.
 */
public interface ExampleLogic {
	/**
	 * Get the current time on the server.
	 * 
	 * @return Current time on the server.
	 */
	String getNow();

	/**
	 * Get the pages associated to the current site.
	 * 
	 * @return List of pages associated to the current site. Empty list (not
	 *         null) if no pages are found.
	 */
	List<SitePage> getPages();
}
