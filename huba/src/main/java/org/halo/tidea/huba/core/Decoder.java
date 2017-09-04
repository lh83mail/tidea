package org.halo.tidea.huba.core;

import java.util.Map;

/**
 * Created by dell01 on 2017/9/4.
 */
public interface Decoder<T> {
   Map<String,Object> decode(T object);
}
