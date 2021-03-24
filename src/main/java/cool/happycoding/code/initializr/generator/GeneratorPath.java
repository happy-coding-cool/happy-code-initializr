package cool.happycoding.code.initializr.generator;

/**
 *
 * @author lanlanhappy
 */
public class GeneratorPath {

    public static final String POM_XML_PATH = "%s/pom.xml";
    public static final String POM_XML_FTL_PATH = "templates/pom.xml.ftl";

    public static final String BUILD_GRADLE_PATH = "%s/build.gradle";
    public static final String BUILD_GRADLE_FTL_PATH = "templates/build.gradle.ftl";

    public static final String SETTINGS_GRADLE_PATH = "%s/settings.gradle";
    public static final String SETTINGS_GRADLE_FTL_PATH = "templates/settings.gradle.ftl";

    public static final String README_PATH = "%s/README.md";
    public static final String README_FTL_PATH = "templates/README.md.ftl";

    public static final String HELP_PATH = "%s/HELP.md";
    public static final String HELP_FTL_PATH = "templates/HELP.md.ftl";

    public static final String IGNORE_PATH = "%s/.gitignore";
    public static final String IGNORE_FTL_PATH = "templates/.gitignore.ftl";

    public static final String APPLICATION_YML_PATH = "%s/src/main/resources/application.yml";
    public static final String APPLICATION_YML_FTL_PATH = "templates/application.yml.ftl";

    public static final String SRC_MAIN_APP_PATH = "%s/src/main/java/%s/%sApplication.java";
    public static final String SRC_MAIN_APP_FTL_PATH = "templates/application.java.ftl";






    public enum GenerateFile{

        // Pom文件
        POM_FILE(POM_XML_PATH, POM_XML_FTL_PATH),


        // gradle
        BUILD_GRADLE_FILE(BUILD_GRADLE_PATH, BUILD_GRADLE_FTL_PATH),
        SETTINGS_GRADLE_FILE(SETTINGS_GRADLE_PATH, SETTINGS_GRADLE_FTL_PATH),

        // readme
        README_FILE(README_PATH, README_FTL_PATH),
        // help
        HELP_FILE(HELP_PATH, HELP_FTL_PATH),

        // ignore
        IGNORE_FILE(IGNORE_PATH, IGNORE_FTL_PATH),

        // application.yml file
        APPLICATION_FILE(APPLICATION_YML_PATH, APPLICATION_YML_FTL_PATH),
        // application java
        APPLICATION_JAVA_FILE(SRC_MAIN_APP_PATH, SRC_MAIN_APP_FTL_PATH)
        ;

        String filePath;
        String templatePath;
        GenerateFile(String filePath, String templatePath){
            this.filePath = filePath;
            this.templatePath = templatePath;
        }

        public String getFilePath() {
            return filePath;
        }

        public String getTemplatePath() {
            return templatePath;
        }
    }
}
