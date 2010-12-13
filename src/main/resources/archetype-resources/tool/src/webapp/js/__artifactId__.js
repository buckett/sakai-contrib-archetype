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
/* global $, setMainFrameHeight */

var sakai = sakai || {};
sakai.${artifactId} = sakai.${artifactId} || {};

sakai.${artifactId}.init = function() {
    sakai.${artifactId}.fitContent();
};

sakai.${artifactId}.fitContent = function() {
	// resize the containing iframe to show all of our content
	var iframeId = $(".portletMainIframe", parent.document).attr("id");
    setMainFrameHeight(iframeId);
};

sakai.${artifactId}.alertTimestamp = function() {
	jQuery.getJSON(window.location.pathname + "/time", function(data) {
        alert(data.timestamp);
    })
};

sakai.${artifactId}.printTimestamp = function() {
    jQuery.getJSON(window.location.pathname + "/time", function(data) {
        $("#serverTime").html($("#timestamp").tmpl(data));
    })
};

sakai.${artifactId}.printPages = function() {
    jQuery.getJSON(window.location.pathname + "/pages", function(data) {
        $("#sitePages").html($("#pages").tmpl(data));
        sakai.${artifactId}.fitContent();
    });
};

$(document).ready(sakai.${artifactId}.init);