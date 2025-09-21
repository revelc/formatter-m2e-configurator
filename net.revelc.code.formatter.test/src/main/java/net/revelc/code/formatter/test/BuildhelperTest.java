/*
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
package net.revelc.code.formatter.test;

import java.io.IOException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2e.core.project.ResolverConfiguration;
import org.eclipse.m2e.tests.common.AbstractMavenProjectTestCase;
import org.eclipse.m2e.tests.common.ClasspathHelpers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@SuppressWarnings("restriction")
public class BuildhelperTest extends AbstractMavenProjectTestCase {

    // Override setup to force junit 5 as m2e is junit 4
    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    void simpleSample() throws CoreException, IOException, InterruptedException {
        IProject project = importBuildHelperProject("simple-sample");
        IJavaProject javaProject = JavaCore.create(project);
        IClasspathEntry[] classpath = javaProject.getRawClasspath();

        ClasspathHelpers.assertClasspath(
                new String[] {
                    "/simple-sample/src/main/java", //
                    "/simple-sample/src/main/resources", //
                    "/simple-sample/src/test/java", //
                    "/simple-sample/src/test/resources", //
                    "org.eclipse.jdt.launching.JRE_CONTAINER/.*", //
                    "org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER", //
                },
                classpath);
    }

    // Disabled because 'pom' project is not a java project so this is not valid to use and probably not applicable
    // to formatting plugin for this specific testing
    @Disabled
    @Test
    void modularSample() throws CoreException, IOException, InterruptedException {
        IProject project = importBuildHelperProject("modular-sample");
        IJavaProject javaProject = JavaCore.create(project);
        IClasspathEntry[] classpath = javaProject.getRawClasspath();

        ClasspathHelpers.assertClasspath(
                new String[] {
                    "/modular-sample/src/main/java", //
                    "/modular-sample/src/main/resources", //
                    "/modular-sample/src/test/java", //
                    "/modular-sample/src/test/resources", //
                    "org.eclipse.jdt.launching.JRE_CONTAINER/.*", //
                    "org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER", //
                },
                classpath);
    }

    private IProject importBuildHelperProject(String name) throws CoreException, IOException, InterruptedException {
        ResolverConfiguration configuration = new ResolverConfiguration();
        IProject project = importProject("projects/" + name + "/pom.xml", configuration);
        waitForJobsToComplete();

        project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
        waitForJobsToComplete();

        assertNoErrors(project);
        return project;
    }
}
