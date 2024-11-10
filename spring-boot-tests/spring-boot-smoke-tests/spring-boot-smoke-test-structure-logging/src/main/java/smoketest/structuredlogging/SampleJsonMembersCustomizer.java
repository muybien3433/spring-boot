/*
 * Copyright 2012-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package smoketest.structuredlogging;

import org.springframework.boot.json.JsonWriter.Members;
import org.springframework.boot.json.JsonWriter.ValueProcessor;
import org.springframework.boot.logging.structured.StructureLoggingJsonMembersCustomizer;

public class SampleJsonMembersCustomizer implements StructureLoggingJsonMembersCustomizer<Object> {

	@Override
	public void customize(Members<Object> members) {
		members.applyingValueProcessor(
				ValueProcessor.of(String.class, "!!%s!!"::formatted).whenHasUnescapedPath("process.thread.name"));
	}

}
