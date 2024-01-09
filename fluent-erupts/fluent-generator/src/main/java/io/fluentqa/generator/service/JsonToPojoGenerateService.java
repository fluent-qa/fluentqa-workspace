package io.fluentqa.generator.service;

import com.beust.jcommander.internal.Lists;
import org.jsonschema2pojo.Jsonschema2Pojo;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.cli.Arguments;
import org.jsonschema2pojo.cli.CommandLineLogger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class JsonToPojoGenerateService {

    public void generate(String schemaFile,
                         String packageName, String className,
                         String outputDir) throws IOException {
        URL source = JsonToPojoGenerateService.class.getResource("/schema/" + schemaFile);
        Arguments config = new Arguments() {

            @Override
            public Iterator<URL> getSource() {
                return Lists.newArrayList(
                        source
                ).iterator();
            }

            @Override
            public File getTargetDirectory() {
                return new File(outputDir);
            }

            @Override
            public boolean isIncludeToString() {
                return false;
            }

            @Override
            public boolean isIncludeHashcodeAndEquals() {
                return false;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        Jsonschema2Pojo.generate(config,
                new CommandLineLogger("info"));
    }
}
