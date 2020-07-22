package edu.miu.cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class MovieSerivceClient {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	@Value("${EurekaClient}")
	private String serviceName;

	public List<MovieResponse> getMovie() {
		return restTemplate.getForObject(lookUpUrlFor(serviceName + "movie?=fetch-all=true"), List.class);

	}

	private String lookUpUrlFor(String appName) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);

		return instanceInfo.getHomePageUrl();
	}

}
