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

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.sakaiproject.time.api.Time;
import org.sakaiproject.time.api.TimeService;

@RunWith(MockitoJUnitRunner.class)
public class TimestampLogicImplTest {
	private static final String FULL_TIME = "Saturday, December 11, 2010 4:55:48 PM EST";

	@Mock
	private TimeService timeService;
	@Mock
	private Time time;

	private TimestampLogicImpl timestampLogic;

	@Before
	public void setUp() {
		when(time.toStringLocalFullZ()).thenReturn(FULL_TIME);
		when(timeService.newTime()).thenReturn(time);
		timestampLogic = new TimestampLogicImpl();
		timestampLogic.setTimeService(timeService);
	}

	@Test
	public void getTime() {
		String now = timestampLogic.getNow();
		assertNotNull(now);
		Assert.assertEquals(FULL_TIME, now);
	}
}
