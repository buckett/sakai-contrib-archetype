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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExampleResourceTest {
	private static final String FULL_TIME = "Saturday, December 11, 2010 4:55:48 PM EST";

	@Mock
	TimestampLogic timestampLogic;

	ExampleResource resource;

	@Before
	public void setUp() {
		when(timestampLogic.getNow()).thenReturn(FULL_TIME);

		resource = new ExampleResource();
		resource.setTimestampLogic(timestampLogic);
	}

	@Test
	public void getTimestamp() throws Exception {
		JSONObject json = resource.getTimestamp();
		assertNotNull(json);
		String timestamp = json.getString("timestamp");
		assertNotNull(timestamp);
		assertEquals(FULL_TIME, timestamp);
	}
}
