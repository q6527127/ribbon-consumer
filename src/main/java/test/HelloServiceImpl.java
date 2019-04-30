package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloServiceImpl implements HelloService{
	
	@Autowired
	RestTemplate res;
	
	@HystrixCommand(fallbackMethod="helloFallBack")
	public String helloService() {
		return res.getForObject("http://HELLO-SERVICE/hello", String.class);
	}
	
	public String helloFallBack() {
		return "error";
	}
}
