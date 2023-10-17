package io.fluent.git.github.config;

import com.jcabi.github.Github;
import com.jcabi.github.RtGithub;
import io.fluent.quickdao.QuickDao;
import io.fluent.quickdao.datasource.model.DataSourceSetting;
import io.github.cdimascio.dotenv.Dotenv;

public class ConfigHolder {

    public static Dotenv dotenv = Dotenv.load();

    public static DataSourceSetting createDatabaseSetting() {
        return DataSourceSetting.builder().
                url(dotenv.get("JDBC_URL"))
                .driver(dotenv.get("DB_DRIVER"))
                .username(dotenv.get("DB_USER"))
                .password(dotenv.get("DB_PWD")).build();


    }

    public static QuickDao getDao() {
        DataSourceSetting setting = createDatabaseSetting();
        return QuickDao.createDao(createDatabaseSetting());
    }

    public static Github getGithubApiClient() {
        String githubAccessToken = dotenv.get("GITHUB_ACCESS_TOKEN");

        return new RtGithub(githubAccessToken);
    }


}
