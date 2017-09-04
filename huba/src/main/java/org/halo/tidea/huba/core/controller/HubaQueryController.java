package org.halo.tidea.huba.core.controller;

import org.halo.tidea.huba.core.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dell01 on 2017/9/5.
 */
@RestController
public class HubaQueryController {

    @RequestMapping("query")
    public Page<Map<String, Object>> query() {
        return null;
    }
}
