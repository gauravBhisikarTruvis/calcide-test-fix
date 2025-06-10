package com.calcite_new.sqlanalyzer.recommendation;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class RuleSqlRegistry {

    private static final String RULES_PATH = "rules/";
    private final Map<Integer, String> ruleSqlMap = new HashMap<>();

    public RuleSqlRegistry(ResourceLoader resourceLoader) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(resourceLoader);
            Resource[] resources = resolver.getResources("classpath:" + RULES_PATH + "*.sql");

            for (Resource resource : resources) {
                String fileName = resource.getFilename();
                if (fileName != null && fileName.endsWith(".sql")) {
                    String ruleCode = fileName.replace(".sql", "");
                    String sql = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
                    ruleSqlMap.put(Integer.valueOf(ruleCode), sql);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load SQL rule file", e);
        }
    }

    public Optional<String> getSqlForRule(Integer ruleCode) {
        return Optional.ofNullable(ruleSqlMap.get(ruleCode));
    }
}

