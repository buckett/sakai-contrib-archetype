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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sakaiproject.site.api.SitePage;

/**
 * Example JAX-RS resource for getting information from the server.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
	// ---------- dependency injection ----------
	private ExampleLogic exampleLogic;
	public void setExampleLogic(ExampleLogic exampleLogic) {
		this.exampleLogic = exampleLogic;
	}

	/**
	 * Default view for the base path.
	 *
	 * @param context
	 * @return
	 * @throws IOException
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String get(@Context ServletContext context) throws IOException {
		InputStream is = context.getResourceAsStream("/index.html");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringWriter sw = new StringWriter();
		String text = "";

		while ((text = reader.readLine()) != null) {
			sw.write(text);
		}
		return sw.toString();
	}

	/**
	 * Gets the current time.
	 * 
	 * @return The current time on the server.
	 * @throws JSONException
	 */
	@GET
	@Path("time")
	public JSONObject getTimestamp() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("timestamp", exampleLogic.getNow());
		return json;
	}

	/**
	 * Gets the boolean value of the <code>bool</code> request parameter.
	 * 
	 * @param bool
	 * @return Boolean value of the <code>bool</code>request parameter based on
	 *         {@link Boolean.parseBoolean(String)}.
	 * @throws JSONException
	 */
	@GET
	@Path("bool/{bool}")
	public JSONObject getBoolean(@PathParam("bool") boolean bool)
			throws JSONException {
		JSONObject json = new JSONObject();
		json.put("bool", bool);
		return json;
	}

	/**
	 * Gets the pages associated to the current site.
	 * 
	 * @return List of pages associated to the current site. Empty array if no pages found.
	 * @throws JSONException
	 */
	@GET
	@Path("pages")
	public JSONObject getPages() throws JSONException {
		JSONObject json = new JSONObject();
		List<SitePage> pages = exampleLogic.getPages();
		if (pages.size() > 0) {
			for (SitePage page : pages) {
				json.append("pages", page.getTitle());
			}
		} else {
			json.put("pages", new JSONArray());
		}
		return json;
	}
}
