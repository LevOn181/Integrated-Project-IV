package core.domain;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppSettings {
    private final Properties prop = new Properties();

    private static final String propFile = "core.properties";

    private static final String HASH_STRENGTH_KEY = "passwordHashStrength";

    private static final String HASH_ALGORITHM_KEY = "passwordHashAlgorithm";

    private static final String HASH_KEY_LENGTH_KEY = "passwordKeyLength";

    private static final String ACRONYM_MAX_LENGTH_KEY = "teacherAcronymLength";

    private static final String BOARD_ROWS_KEY = "boardMaxRow";

    private static final String BOARD_COLUMNS_KEY = "boardMaxColumn";

    private static final String TITLE_MAX_KEY = "titleMaxLength";

    private static final String POST_TEXT_MAX_KEY = "postTextMaxLength";

    private static final String CODE_MAX_KEY = "codeMaxLength";

    public AppSettings(){loadProperties();}

    private void loadProperties() {
        InputStream in = getClass().getResourceAsStream(propFile);
        try {
            prop.load(in);
            if (in != null)
                in.close();
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file!");
        }
    }

    public Integer getAcronymMaxLength(){ return Integer.valueOf(this.prop.getProperty(ACRONYM_MAX_LENGTH_KEY)); }

    public String getHashingAlgorithm(){ return this.prop.getProperty(HASH_ALGORITHM_KEY); }

    /*  defines the number of iterations that the hashing algorithm will perform.
        The higher the number the slower and more secure will be the algorithm.
        | Limit is 65536 | hashing strength is set to a low number, so it is faster.
     */
    public Integer getHashAlgorithmStrength(){ return Integer.valueOf(this.prop.getProperty(HASH_STRENGTH_KEY)); }

    public Integer getHashKeyLenght(){ return Integer.valueOf(this.prop.getProperty(HASH_KEY_LENGTH_KEY)); }

    public Integer getBoardRowMax(){ return Integer.valueOf(this.prop.getProperty(BOARD_ROWS_KEY)); }

    public Integer getBoardColumnMax(){ return Integer.valueOf(this.prop.getProperty(BOARD_COLUMNS_KEY)); }

    public Integer getTitleMaxLength(){ return Integer.valueOf(this.prop.getProperty(TITLE_MAX_KEY)); }

    public Integer getPostTextMaxLength(){ return Integer.valueOf(this.prop.getProperty(POST_TEXT_MAX_KEY)); }

    public Integer getCodeMaxLength(){ return Integer.valueOf(this.prop.getProperty(CODE_MAX_KEY)); }

}