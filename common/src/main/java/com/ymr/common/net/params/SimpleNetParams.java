package com.ymr.common.net.params;

import com.android.volley.Request;
import com.ymr.common.Env;
import com.ymr.common.util.Tool;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymr on 15/6/18.
 */
public abstract class SimpleNetParams implements NetRequestParams, Serializable {
    public static final long CURR_API_VERSION = 1;
    private String tailUrl;

    public SimpleNetParams(String tailUrl) {
        this.tailUrl = tailUrl;
    }

    public void setTailUrl(String tailUrl) {
        this.tailUrl = tailUrl;
    }

    @Override
    public int getMethod() {
        return getPostParams() == null ? Request.Method.GET : Request.Method.POST;
    }

    @Override
    public String getUrl() {
        Map<String, String> childGETParams = getChildGETParams();
        Map<String, String> sendMap = new HashMap<>();
        if (childGETParams != null && childGETParams.size() > 0) {
            sendMap.putAll(childGETParams);
        }
        if (Env.sCommonParamsGetter != null) {
            sendMap.putAll(Env.sCommonParamsGetter.getCommonParams());
        }
        return Tool.getUrl(tailUrl, sendMap);
    }

    /**
     * for method GET
     *
     * @return
     */
    protected abstract Map<String, String> getChildGETParams();

    @Override
    public Map<String, String> getPostParams() {
        return null;
    }

    @Override
    public String toString() {
        return "SimpleNetParams{" +
                "url = " + getUrl() + " post = " + getPostParams() +
                '}';
    }

    @Override
    public Map<String, String> getHeaders() {
        return null;
    }

    @Override
    public String getCookies() {
        return null;
    }
}
