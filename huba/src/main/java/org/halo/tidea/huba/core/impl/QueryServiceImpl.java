package org.halo.tidea.huba.core.impl;

import org.halo.tidea.huba.core.DataSetConfig;
import org.halo.tidea.huba.core.HubaConfiguration;
import org.halo.tidea.huba.core.Query;
import org.halo.tidea.huba.core.QueryService;
import org.halo.tidea.huba.core.impl.hibernate.HibernateQuery;
import org.halo.tidea.huba.core.service.DataSetConfigurationService;

/**
 * Created by dell01 on 2017/9/4.
 */
public class QueryServiceImpl implements QueryService {
    private DataSetConfigurationService dataSetConfigurationService;
    private HubaConfiguration hubaConfiguration;

    @Override
    public Query createQuery(String modelKey) {
        DataSetConfig config = dataSetConfigurationService.get(modelKey);
        return new HibernateQuery(config);
    }
}
