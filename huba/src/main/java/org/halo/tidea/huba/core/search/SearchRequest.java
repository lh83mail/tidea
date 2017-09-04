package org.halo.tidea.huba.core.search;

/**
 * 查询请求
 * Created by dell01 on 2017/9/5.
 */
public interface SearchRequest {
    SearchParamter get(String param);
}
