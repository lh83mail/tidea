package org.halo.tidea.huba.core.search;

/**
 * 查询参数
 * Created by dell01 on 2017/9/5.
 */
public interface SearchParamter {
    boolean isOptional();

    boolean isEmpty();

    Object getValue();
}
