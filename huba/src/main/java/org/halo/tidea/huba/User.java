package org.halo.tidea.huba;

import org.halo.tidea.huba.core.Query;
import org.halo.tidea.huba.core.QueryService;

import java.util.List;
import java.util.Map;

/**
 * Created by dell01 on 2017/9/4.
 */
public class User {
    private QueryService queryService;

    public void query() {
        String modelKey = "user";
        Query query = queryService.createQuery(modelKey);
        query.setStart(0);
        query.setLimit(25);
//      query.addFilter();
//      query.orderBy();

        List<Map<String, Object>> list = query.list();

//        queryService
//                .createQuery(modelKey)
//                .addParamters()
//                .addSortKey()
//                .list();

    }
}
