package org.raspberry.piforge.engine.executor;

import org.raspberry.piforge.core.entity.pipeline.Pipeline;
import org.raspberry.piforge.core.entity.pipeline.PipelineStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PipelineExecutor {

    @Autowired
    private PipelineStepExecutor pipelineStepExecutor;

    public int execute(File workspace, Pipeline pipeline) {
        for (PipelineStep pipelineStep : pipeline.getPipelineSteps()) {
            int exitCode = pipelineStepExecutor.execute(workspace, pipelineStep);
            if (exitCode != 0) {
                return exitCode;
            }
        }

        return 0;
    }

}