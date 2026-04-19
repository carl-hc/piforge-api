package org.raspberry.piforge.engine.resolver;

import org.raspberry.piforge.core.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CommandResolver {

    public List<String> resolve(String command, Map<String, String> params) {
        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        Matcher matcher = pattern.matcher(command);

        while (matcher.find()) {
            String token = this.extractToken(matcher);
            String value = this.resolveToken(token, params);

            result.add(value);
        }

        return result;
    }

    private String extractToken(Matcher matcher) {
        return matcher.group(1) != null
                ? matcher.group(1)
                : matcher.group(2);
    }

    private String resolveToken(String token, Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile("\\{\\{\\s*(.*?)\\s*\\}\\}");
        Matcher matcher = pattern.matcher(token);

        while (matcher.find()) {
            String param = this.extractParam(matcher);
            String value = this.resolveParam(param, params);

            matcher.appendReplacement(result, Matcher.quoteReplacement(value));
        }

        matcher.appendTail(result);

        return result.toString();
    }

    private String extractParam(Matcher matcher) {
        return matcher.group(1);
    }

    private String resolveParam(String param, Map<String, String> params) {
        if (!params.containsKey(param)) {
            throw new BadRequestException("Param with name '%s' not declared", param);
        }

        return params.get(param);
    }

}