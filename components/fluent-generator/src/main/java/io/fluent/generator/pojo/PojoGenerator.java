package io.fluent.generator.pojo;

import com.beust.jcommander.internal.Lists;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JType;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.cli.Arguments;
import org.jsonschema2pojo.cli.CommandLineLogger;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class PojoGenerator {

    public void generate(String schemaFile,
                         String packageName,String className,
                         String outputDir) throws IOException {
        URL source = PojoGenerator.class.getResource("/schema/"+schemaFile);
        Arguments config = new Arguments(){

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
