/*
 * Copyright  2002-2004 Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.tools.ant.taskdefs;

import java.io.File;

import org.apache.tools.ant.BuildFileTest;

/**
 * Testcase for the war task
 *
 * @author Conor MacNeill
 */
public class WarTest extends BuildFileTest {
    public static final String TEST_BUILD_FILE
        = "src/etc/testcases/taskdefs/war.xml";

    public WarTest(String name) {
        super(name);
    }

    public void setUp() {
        configureProject(TEST_BUILD_FILE);
    }

    public void tearDown() {
        executeTarget("clean");
    }

    /**
     * Test direct dependency removal
     */
    public void testLibRefs() {
        executeTarget("testlibrefs");
        File f = getProject().resolveFile("working/WEB-INF/lib/war.xml");
        assertTrue("File has been put into lib", f.exists());
    }
}
