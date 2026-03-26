package com.chd.api;

import com.chd.api.response.Response;

/**
 * @className: IDCCService
 * @author: powfu
 * @date: 26/3/2026 下午5:11
 * @Version: 1.0
 * @description:
 */
public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);

}
