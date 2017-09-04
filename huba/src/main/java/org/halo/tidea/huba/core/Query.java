package org.halo.tidea.huba.core;

import java.util.List;
import java.util.Map;

/**
 * Created by dell01 on 2017/9/4.
 */
public interface Query {
    List<Map<String,Object>> list();
    int count();

    void setStart(int i);

    void setLimit(int i);
}
