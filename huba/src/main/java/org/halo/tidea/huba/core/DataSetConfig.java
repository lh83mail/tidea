package org.halo.tidea.huba.core;

import java.util.List;

/**
 * Created by dell01 on 2017/9/4.
 */
public class DataSetConfig {
    private String key;
    private int version;
    private String document;


    public Decoder<Object> getDecorder() {
        return null;
    }

    /**
     * 主要实体类
     */
    public Class<?> getMainEntityClass() {
        return null;
    }

    public List<String> getQueryParamters() {
        return null;
    }
}
