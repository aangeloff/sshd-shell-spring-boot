/*
 * Copyright 2017 anand.
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
package sshd.shell.springboot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.condition.AutoConfigurationReportEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import sshd.shell.springboot.autoconfiguration.SshdShellCommand;
import sshd.shell.springboot.console.ConsoleIO;

/**
 *
 * @author anand
 */
@Component
@ConditionalOnClass(AutoConfigurationReportEndpoint.class)
@SshdShellCommand(value = "autoConfigurationReport", description = "Autoconfiguration report")
public final class AutoConfigurationReportCommand {
    
    @Autowired
    private AutoConfigurationReportEndpoint autoConfReportEndpoint;
    
    public String autoConfigurationReport(String arg) {
        return ConsoleIO.asJson(autoConfReportEndpoint.getEvaluationReport());
    }
}
