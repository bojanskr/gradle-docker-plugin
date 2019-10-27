/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bmuschko.gradle.docker.tasks

import com.github.dockerjava.api.model.Version
import groovy.transform.CompileStatic

@CompileStatic
class DockerVersion extends AbstractDockerRemoteApiTask {

    @Override
    void runRemoteCommand() {
        logger.quiet "Retrieving Docker version."
        Version version = dockerClient.versionCmd().exec()
        logger.quiet "Version          : $version.version"
        logger.quiet "Git Commit       : $version.gitCommit"
        logger.quiet "Go Version       : $version.goVersion"
        logger.quiet "Kernel Version   : $version.kernelVersion"
        logger.quiet "Architecture     : $version.arch"
        logger.quiet "Operating System : $version.operatingSystem"
    }
}
