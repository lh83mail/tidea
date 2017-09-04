package org.halo.tidea.huba.core.impl.hibernate;

import org.halo.tidea.huba.core.DataSetConfig;
import org.halo.tidea.huba.core.Decoder;
import org.halo.tidea.huba.core.Query;
import org.halo.tidea.huba.core.search.SearchParamter;
import org.halo.tidea.huba.core.search.SearchRequest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dell01 on 2017/9/4.
 */
public class HibernateQuery implements Query {
    private HibernateTemplate hibernateTemplate;
    private DataSetConfig config;

    public HibernateQuery(DataSetConfig config) {
        this.config = config;
    }

    @Override
    public List<Map<String, Object>> list() {
        final String queryString = this.createQueryString();
        List<Object> list = hibernateTemplate.execute(new HibernateCallback<List<Object>>() {
            @Override
            public List<Object> doInHibernate(Session session) throws HibernateException {
               org.hibernate.Query query =   session.createQuery(queryString);
               applyParamters(query);
               query.setFirstResult(getStart());
               query.setMaxResults(getLimits());
               return query.list();
            }
        });

        // 编码结果
        ArrayList<Map<String, Object>> result = new ArrayList<>();
        Decoder<Object> decoder = config.getDecorder();
        list.forEach(e -> {
            Map<String, Object> elem = decoder.decode(e);
           result.add(elem);
        });
        return result;
    }

    private void applyParamters(org.hibernate.Query query) {

    }
    private SearchRequest searchRequest;

    private String createQueryString() {
        // 1. 直接定义查询字符串
        // 2. 定义对象连接关系
        // 3. 指定对象

        StringBuffer buf = new StringBuffer();
        buf.append(" from ")
                .append(config.getMainEntityClass().getName());
        List<String> queryParamters = config.getQueryParamters();
        List<Object> values = new ArrayList<>();
        for (String param : queryParamters) {
           SearchParamter searchParamter = searchRequest.get(param);
           if (searchParamter.isOptional() && !searchParamter.isEmpty()){
                buf.append(" and  ").append(param).append(" = ?");
                values.add(searchParamter.getValue());
            }
        }
        // select m, d.name
        // from M m
        //   left join D d
        //   left join X x
        // where
        //   m.id = d.xid and m.id = x.xid and d.mid = m.id
        //  and x = xxx
        //  and (d.name = 'aaa' or d.title like '%ssss%')
        //  and xxxx
        //  order by xxxx asc, mm desc;

        return buf.toString();
    }

    private int getStart() {
        return 0;
    }

    private int getLimits() {
        return 25;
    }

    @Override
    public void setStart(int i) {}

    @Override
    public void setLimit(int i) {}



    @Override
    public int count() {
        return 0;
    }
}
