package org.raspberry.piforge.engine.executor;

import org.raspberry.piforge.core.entity.pipeline.PipelineStep;
import org.raspberry.piforge.core.entity.pipeline.PipelineStepParam;
import org.raspberry.piforge.engine.resolver.CommandResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PipelineStepExecutor {

    @Autowired
    private CommandExecutor commandExecutor;
    @Autowired
    private CommandResolver commandResolver;

    public int execute(File workspace, PipelineStep pipelineStep) {
        List<String> command = commandResolver.resolve(
                this.getCommand(pipelineStep),
                this.getParams(pipelineStep)
        );

        return commandExecutor.execute(workspace, command);
    }

    private String getCommand(PipelineStep pipelineStep) {
        return pipelineStep.getCommand();
    }

    private Map<String, String> getParams(PipelineStep pipelineStep) {
        Map<String, String> params = new HashMap<>();
        if (pipelineStep.getRuntimeVersion() != null) {
            params.put("runtimePath", pipelineStep.getRuntimeVersion().getPath());
        }

        for (PipelineStepParam pipelineStepParam : pipelineStep.getPipelineStepParams()) {
            params.put(pipelineStepParam.getName(), pipelineStepParam.getValue());
        }

        return params;
    }

}