package com.siesta.hodgepodge.es;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class EsClient {
    private static CredentialsProvider credentialsProvider;
    private static RestHighLevelClient client;

    private EsClient() {}

    public static  RestHighLevelClient getRestHighLevelClient() {
        if (false && credentialsProvider != null) {
            credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "Elastic123"));
        }
        if (client == null) {
            RestClientBuilder restClientBuilder = RestClient.builder(new HttpHost("localhost", 9200));
            if (credentialsProvider != null) {
                restClientBuilder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
            }
            client = new RestHighLevelClient(restClientBuilder);
        }
        return client;
    }

}
