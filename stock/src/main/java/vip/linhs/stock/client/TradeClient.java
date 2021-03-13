package vip.linhs.stock.client;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vip.linhs.stock.exception.ServiceException;
import vip.linhs.stock.exception.UnauthorizedException;
import vip.linhs.stock.util.HttpUtil;

@Component
public class TradeClient {

    private ThreadLocal<ClientWrapper> threadLocal = new ThreadLocal<>();

    @Autowired
    private CloseableHttpClient httpClient;

    public String send(String url, Map<String, Object> params, Map<String, String> header) {
        String content = HttpUtil.sendPost(httpClient, url, params, header);
        if (content.contains("Object moved")) {
            throw new UnauthorizedException("unauthorized " + url);
        }
        return content;
    }

    public void openSession() {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        ClientWrapper wrapper = new ClientWrapper();
        wrapper.httpClient = httpClient;
        wrapper.cookieStore = cookieStore;
        threadLocal.set(wrapper);
    }

    public String sendNewInstance(String url, Map<String, Object> params) {
        ClientWrapper clientWrapper = threadLocal.get();
        assertOpened(clientWrapper);
        return HttpUtil.sendPost(clientWrapper.httpClient, url, params);
    }

    public String getCurrentCookie() {
        ClientWrapper clientWrapper = threadLocal.get();
        assertOpened(clientWrapper);
        return clientWrapper.cookieStore.getCookies().stream().map(cookie -> cookie.getName() + "=" + cookie.getValue()).collect(Collectors.joining("; "));
    }

    public void destoryCurrentSession() {
        ClientWrapper clientWrapper = threadLocal.get();
        threadLocal.remove();
        assertOpened(clientWrapper);
        try {
            clientWrapper.httpClient.close();
        } catch (IOException e) {
            // ignore
        }
    }

    private void assertOpened(ClientWrapper clientWrapper) {
        if (clientWrapper == null) {
            throw new ServiceException("please call open session first");
        }
    }

    private static class ClientWrapper {
        private CloseableHttpClient httpClient;
        private CookieStore cookieStore;
    }

}
