/*
 * Copyright (c) 2015.  Airbnb.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.rubicon.metrics;

import com.yammer.metrics.core.MetricName;
import org.junit.Test;

import static com.rubicon.metrics.MetricNameFormatter.format;
import static com.rubicon.metrics.MetricNameFormatter.formatWithScope;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class MetricNameFormatterTest {

  @Test
  public void testFormat() throws Exception {
    assertEquals(
        format(new MetricName("kafka.common", "AppInfo", "Version", null, "kafka.common:type=AppInfo,name=Version")),
        "kafka.common.AppInfo.Version");
    assertEquals(
        format(new MetricName("kafka.common", "AppInfo", "Version", "my_scope", "kafka.common:type=AppInfo,name=Version")),
        "kafka.common.AppInfo.Version");
  }

  @Test
  public void testFormatWithScope() throws Exception {
    assertEquals(
        formatWithScope(new MetricName("kafka.common", "AppInfo", "Version", null, "kafka.common:type=AppInfo,name=Version")),
        "kafka.common.AppInfo.Version");
    assertEquals(
        formatWithScope(new MetricName("kafka.common", "AppInfo", "Version", "", "kafka.common:type=AppInfo,name=Version")),
        "kafka.common.AppInfo.Version");
    assertEquals(
        formatWithScope(new MetricName("kafka.common", "AppInfo", "Version", "my_scope", "kafka.common:type=AppInfo,name=Version")),
        "kafka.common.AppInfo.my_scope.Version");
  }
}
